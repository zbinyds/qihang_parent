package com.zbinyds.eduService.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zbinyds.R;
import com.zbinyds.eduService.pojo.EduCourse;
import com.zbinyds.eduService.pojo.EduTeacher;
import com.zbinyds.eduService.service.EduCourseService;
import com.zbinyds.eduService.service.EduTeacherService;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * @author zbinyds
 * @time 2022/09/24 16:42
 * <p>
 * 用户首页控制器
 */

@Api(tags = "前台首页模块接口管理")
@RestController
@RequestMapping("/eduService/front")
//@CrossOrigin // 允许跨域访问
public class IndexFrontController {

    @Autowired
    private EduCourseService courseService;

    @Autowired
    private EduTeacherService teacherService;

    /**
     * 获取前八门热门课程，前四名名师数据
     *
     * @return
     */
    @Cacheable(value = "index",key = "'courseaAndTeacherList'")
    @ApiOperation("获取前台首页热点数据")
    @GetMapping("/index")
    public R index() {
        // 获取前八门热门课程
        LambdaQueryWrapper<EduCourse> courseQueryWrapper = new LambdaQueryWrapper<>();
        courseQueryWrapper.orderByAsc(EduCourse::getId).last("limit 8"); // 根据id排序取前8门课程
        List<EduCourse> courseList = courseService.list(courseQueryWrapper);

        // 获取前四名名师信息
        LambdaQueryWrapper<EduTeacher> teacherQueryWrapper = new LambdaQueryWrapper<>();
        teacherQueryWrapper.orderByAsc(EduTeacher::getId).last("limit 4"); // 根据id排序取前4位名师
        List<EduTeacher> teacherList = teacherService.list(teacherQueryWrapper);

        if (Objects.isNull(courseList) || Objects.isNull(teacherList)) {
            throw new QiHangException("20001", "获取热点数据失败！");
        }
        return R.success().message("获取数据成功！").data("courseList", courseList).data("teacherList", teacherList);
    }
}
