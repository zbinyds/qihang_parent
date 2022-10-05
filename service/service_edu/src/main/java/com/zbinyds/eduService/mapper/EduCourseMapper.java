package com.zbinyds.eduService.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zbinyds.eduService.pojo.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zbinyds.eduService.pojo.front_vo.CourseQueryVo;
import com.zbinyds.eduService.pojo.vo.PublishCourseInfoVo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-19
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {

    /**
     * 根据课程id查询，课程基本信息。用于课程最终发布展示
     * @param courseId：课程id
     * @return：返回和前端约定好的Json数据格式
     */
    PublishCourseInfoVo getPublishCourseInfo(@Param("courseId") String courseId);

    /**
     * 多表查询：根据课程id，查询课程的基本信息、课程简介、讲师信息。
     * @param courseId：课程id
     * @return
     */
    Map<String, Object> getCourseDetail(@Param("courseId") String courseId);

    /**
     * 带条件的多表分页查询。
     * @param page：分页对象
     * @param courseQueryVo：条件对象
     * @return：返回分页后的对象
     */
    Page<Map> getPage(@Param("page") Page<Map> page, @Param("courseQueryVo") CourseQueryVo courseQueryVo);
}
