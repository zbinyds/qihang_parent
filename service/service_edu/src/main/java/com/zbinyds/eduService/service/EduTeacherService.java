package com.zbinyds.eduService.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zbinyds.eduService.pojo.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zbinyds.eduService.pojo.vo.TeacherVo;

import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-13
 */
public interface EduTeacherService extends IService<EduTeacher> {

    /**
     * 带条件的分页查询-讲师信息
     * @param page：当前页
     * @param pageSize：每页显示的记录数
     * @param teacherVo：封装好的条件信息
     * @return：返回条件查询后的分页信息
     */
    Page<EduTeacher> pageCondition(Integer page, Integer pageSize, TeacherVo teacherVo);

    /**
     * 前台-名师-讲师分页展示
     * @param teacherPage：page对象
     * @return：返回map（封装了约定好的参数信息）
     */
    Map<String, Object> pageTeacherList(Page<EduTeacher> teacherPage);

    /**
     * 根据讲师id，获取该讲师详情信息以及该讲师所讲课程详细信息。
     * @param teacherId：讲师id
     * @return
     */
    Map<String, Object> getTeacherDetailInfo(String teacherId);
}
