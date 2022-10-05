package com.zbinyds.eduService.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zbinyds.R;
import com.zbinyds.eduService.pojo.EduCourse;
import com.zbinyds.eduService.pojo.vo.CourseInfoVo;
import com.zbinyds.eduService.pojo.vo.PublishCourseInfoVo;
import com.zbinyds.eduService.service.EduCourseService;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-19
 */

@Api(tags = "课程管理")
@RestController
@RequestMapping("/eduService/course")
//@CrossOrigin // 允许跨域访问
@Slf4j
public class EduCourseController {

    @Autowired
    private EduCourseService courseService;

    /**
     * 发布课程之添加课程基本信息
     *
     * @param courseInfoVo：课程基本信息
     * @return：返回添加后的课程id及提示信息。
     */
    @ApiOperation("添加课程基本信息")
    @PostMapping
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        log.info("课程简介内容长度：" + courseInfoVo.getDescription().length());
        // 限制添加课程的简介内容长度（MySQL中text字段最大存储容量为65535）
        if (courseInfoVo.getDescription().length() >= 65535) throw new QiHangException("20001", "课程简介内容过大！");

        String id = courseService.saveCourseInfo(courseInfoVo);
        return StringUtils.isEmpty(id) ? R.failed().message("添加课程失败！") : R.success().message("添加课程成功！").data("courseId", id);
    }

    /**
     * 获取课程基本信息-用于数据回显
     *
     * @param courseId：课程id
     * @return：返回课程对象
     */
    @ApiOperation("获取课程基本信息")
    @GetMapping("/{courseId}")
    public R getCourseInfo(@PathVariable String courseId) {
        CourseInfoVo courseInfoVo = courseService.getCourseInfo(courseId);
        return !Objects.isNull(courseInfoVo) ? R.success().data("courseInfo", courseInfoVo) : R.failed().message("获取课程信息失败！");
    }

    /**
     * 修改课程基本信息
     *
     * @param courseInfoVo：封装好的修改对象
     * @return：返回提示信息
     */
    @ApiOperation("修改课程基本信息")
    @PutMapping
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        courseService.updateCourseInfo(courseInfoVo);
        return R.success().message("修改课程信息成功！");
    }

    /**
     * 获取最终确认发布所需数据-最终确认页面展示
     *
     * @param courseId：课程id
     * @return：返回约定好的数据对象
     */
    @ApiOperation("获取最终确认发布所需数据")
    @GetMapping("/getPublishCourseInfo/{courseId}")
    public R getPublishCourseInfo(@PathVariable String courseId) {
        PublishCourseInfoVo info = courseService.getPublishCourseInfo(courseId);
        return !Objects.isNull(info) ? R.success().data("publishCourseInfo", info) : R.failed().message("获取数据失败！");
    }

    /**
     * 课程最终发布-修改课程状态
     *
     * @param courseId：课程id
     * @return：返回提示信息
     */
    @ApiOperation("修改课程状态")
    @PutMapping("/publish/{courseId}")
    public R publish(@PathVariable String courseId) {
        EduCourse course = new EduCourse();
        course.setId(courseId);
        course.setStatus("Normal");
        courseService.updateById(course);
        return R.success().message("发布课程成功！");
    }

    /**
     * 课程列表-展示
     * @return
     */
    @ApiOperation("获取所有课程信息")
    @GetMapping("/getCourseList")
    public R getCourseList() {
        List<EduCourse> courseList = courseService.list(null);
        return R.success().message("获取课程列表成功！").data("courseList", courseList);
    }

    /**
     * 课程列表分页查询-带条件-展示
     * @param page：当前页
     * @param pageSize：页记录数
     * @param title：模糊查询字段-课程名（可选）
     * @param status：查询字段-课程状态（可选）
     * @return
     */
    @ApiOperation("带条件-获取课程分页信息")
    @GetMapping("/pageCourseCondition/{page}/{pageSize}")
    public R pageCourseCondition(
            @PathVariable Integer page,
            @PathVariable Integer pageSize,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String status
    ) {
        Page<EduCourse> coursePage = new Page<>(page, pageSize);
        LambdaQueryWrapper<EduCourse> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(title), EduCourse::getTitle, title);
        queryWrapper.eq(!StringUtils.isEmpty(status), EduCourse::getStatus, status);
        queryWrapper.orderByDesc(EduCourse::getGmtModified);
        courseService.page(coursePage, queryWrapper);
        return R.success().message("获取课程列表成功！")
                .data("total", coursePage.getTotal())
                .data("rows", coursePage.getRecords());
    }

    /**
     * 删除课程-删除课程中所有章节、小节、视频
     * @param courseId
     * @return
     */
    @ApiOperation("删除课程")
    @DeleteMapping("/{courseId}")
    public R deleteCourse(@PathVariable String courseId){
        if (StringUtils.isEmpty(courseId)) throw new QiHangException("20001","必填参数缺失！");
        courseService.removeCourse(courseId);
        return R.success().message("课程删除成功！");
    }
}

