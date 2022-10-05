package com.zbinyds.eduService.service;

import com.zbinyds.eduService.pojo.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zbinyds.eduService.pojo.front_vo.CourseQueryVo;
import com.zbinyds.eduService.pojo.vo.CourseInfoVo;
import com.zbinyds.eduService.pojo.vo.PublishCourseInfoVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-19
 */
public interface EduCourseService extends IService<EduCourse> {

    /**
     * 添加课程基本信息
     *
     * @param courseInfoVo
     * @return
     */
    String saveCourseInfo(CourseInfoVo courseInfoVo);

    /**
     * 获取课程基本信息
     *
     * @param courseId
     * @return
     */
    CourseInfoVo getCourseInfo(String courseId);

    /**
     * 修改课程基本信息
     *
     * @param courseInfoVo
     */
    void updateCourseInfo(CourseInfoVo courseInfoVo);

    /**
     * 获取最终确认发布所需数据
     *
     * @param courseId
     * @return
     */
    PublishCourseInfoVo getPublishCourseInfo(String courseId);

    /**
     * 删除课程
     *
     * @param courseId：课程id
     */
    void removeCourse(String courseId);

    /**
     * TODO 方案一，存在bug，Mp分页查询无法获取课程的评论数。（已解决）
     * 带条件的分页查询，获取课程列表。
     *
     * @param page：当前页
     * @param pageSize：当前页记录数
     * @param courseQueryVo：封装好的查询对象（非必填）
     * @return
     */
    Map<String, Object> getCourseListPageByCondition(Integer page, Integer pageSize, CourseQueryVo courseQueryVo);

    /**
     * 方案二，问题已解决，自定义分页查询编写sql。
     * 带条件的分页查询，获取课程列表。
     *
     * @param page：当前页
     * @param pageSize：当前页记录数
     * @param courseQueryVo：封装好的查询对象（非必填）
     * @return
     */
    Map<String, Object> getPage(Integer page, Integer pageSize, CourseQueryVo courseQueryVo);

    /**
     * 根据id获取课程详情页数据
     *
     * @param courseId：课程id
     * @return
     */
    Map<String, Object> getCourseDetail(String courseId);
}
