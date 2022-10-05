package com.zbinyds.eduService.controller.front;

import com.zbinyds.JwtUtils;
import com.zbinyds.R;
import com.zbinyds.eduService.client.OrderClient;
import com.zbinyds.eduService.pojo.EduCourse;
import com.zbinyds.eduService.pojo.front_vo.CourseQueryVo;
import com.zbinyds.eduService.pojo.vo.chapter.ChapterVo;
import com.zbinyds.eduService.service.EduChapterService;
import com.zbinyds.eduService.service.EduCourseService;
import com.zbinyds.orderVo.CourseOrder;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author zbinyds
 * @time 2022/09/27 22:31
 */

@Api(tags = "前台课程模块接口管理")
@RestController
@RequestMapping("/eduService/courseFront")
//@CrossOrigin // 允许跨域访问
public class CourseFrontController {

    @Autowired
    private EduCourseService courseService;

    @Autowired
    private EduChapterService chapterService;

    @Autowired
    private OrderClient orderClient;

    @ApiOperation("前台-分页带条件查询课程列表")
    @PostMapping("/coursePageCondition/{page}/{pageSize}")
    public R coursePageCondition(
            @PathVariable Integer page,
            @PathVariable Integer pageSize,
            @RequestBody(required = false) CourseQueryVo courseQueryVo) {
        // 参数合法性校验
        if ((Objects.isNull(page) || page == 0) || (Objects.isNull(pageSize) || pageSize == 0))
            throw new QiHangException("20001", "参数不合法！");
        // TODO 方案一。缺点是无法获取课程的评论数，Mp不支持多表联查的分页查询（已解决）
        // Map<String, Object> map = courseService.getCourseListPageByCondition(page, pageSize, courseQueryVo);
        // 方案二。已完善，手动编写sql语句进行分页带条件查询
        Map<String, Object> map1 = courseService.getPage(page, pageSize, courseQueryVo);
        return !Objects.isNull(map1) ? R.success().message("请求成功！").data(map1) : R.failed().message("请求失败！");
    }

    @ApiOperation("前台-获取课程详情信息")
    @GetMapping("/getCourseDetail/{courseId}")
    public R getCourseDetail(@PathVariable String courseId, HttpServletRequest request) {
        // 获取请求用户id（如果用户未登录，为空字符串）
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        // 获取课程基本信息-前台展示
        Map<String, Object> map = courseService.getCourseDetail(courseId);
        // 获取课程章节、小节
        List<ChapterVo> list = chapterService.getChapterAndVideo(courseId);
        // 判断该用户是否有权限观看此课程（免费课程不需要判断），免费课程和已购买课程都是返回true
        boolean isAuth = true;
        if (!"0.00".equals(map.get("price").toString()) && !StringUtils.isEmpty(memberId)) {
            Boolean bool = orderClient.isBuyCourse(courseId, memberId);
            if (Objects.isNull(bool)) throw new QiHangException("20001", "请求失败，目标服务器状态异常！");
            isAuth = bool;
        }
        // 用户未登录（无权观看视频）
        if (StringUtils.isEmpty(memberId)) isAuth = false;
        return R.success().data(map).data("list", list).data("isAuth", isAuth);
    }

    @ApiOperation("通过课程id获取课程信息-order服务调用")
    @PostMapping("/getCourseOrder/{courseId}")
    public CourseOrder getCourseOrder(@PathVariable String courseId) {
        EduCourse course = courseService.getById(courseId);
        CourseOrder courseOrder = new CourseOrder();
        BeanUtils.copyProperties(course, courseOrder);
        return courseOrder;
    }
}
