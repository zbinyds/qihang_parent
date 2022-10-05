package com.zbinyds.eduService.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zbinyds.eduService.pojo.EduCourse;
import com.zbinyds.eduService.pojo.EduTeacher;
import com.zbinyds.eduService.mapper.EduTeacherMapper;
import com.zbinyds.eduService.pojo.vo.TeacherVo;
import com.zbinyds.eduService.service.EduCourseService;
import com.zbinyds.eduService.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-13
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Autowired
    private EduCourseService courseService;

    @Transactional
    public Page<EduTeacher> pageCondition(Integer page, Integer pageSize, TeacherVo teacherVo) {
        Page<EduTeacher> teacherPage = new Page<>(page, pageSize);
        LambdaQueryWrapper<EduTeacher> queryWrapper = new LambdaQueryWrapper<>();
        // 按照讲师名进行模糊查询
        queryWrapper.like(!StringUtils.isEmpty(teacherVo.getName()), EduTeacher::getName, teacherVo.getName());
        // 按照讲师级别进行查询
        queryWrapper.eq(!StringUtils.isEmpty(teacherVo.getLevel()), EduTeacher::getLevel, teacherVo.getLevel());
        // 按照加入时间进行范围查询
        queryWrapper.ge(!StringUtils.isEmpty(teacherVo.getBegin()), EduTeacher::getGmtCreate, teacherVo.getBegin());
        queryWrapper.le(!StringUtils.isEmpty(teacherVo.getEnd()), EduTeacher::getGmtCreate, teacherVo.getEnd());
        // 按照修改时间进行降序排序
        queryWrapper.orderByDesc(EduTeacher::getGmtModified);
        return (Page<EduTeacher>) page(teacherPage, queryWrapper);
    }

    @Override
    public Map<String, Object> pageTeacherList(Page<EduTeacher> teacherPage) {
        LambdaQueryWrapper<EduTeacher> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(EduTeacher::getId);
        baseMapper.selectPage(teacherPage, queryWrapper);

        // 将需要的参数封装到map中，并返回
        HashMap<String, Object> map = new HashMap<>();
        map.put("items", teacherPage.getRecords()); // 分页讲师列表
        map.put("current", teacherPage.getCurrent()); // 当前页
        map.put("pages", teacherPage.getPages()); // 总页数
        map.put("size", teacherPage.getSize()); // 每页讲师数量
        map.put("total", teacherPage.getTotal()); // 总讲师数量
        map.put("hasNext", teacherPage.hasNext()); // 是否存在下一页
        map.put("hasPrevious", teacherPage.hasPrevious()); // 是否存在上一页
        return map;
    }

    @Transactional
    public Map<String, Object> getTeacherDetailInfo(String teacherId) {
        // 根据讲师id查询讲师数据
        EduTeacher teacher = this.getById(teacherId);

        // 查询讲师所讲课程数据
        LambdaQueryWrapper<EduCourse> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EduCourse::getTeacherId, teacherId);
        List<EduCourse> eduCourseList = courseService.list(queryWrapper);

        // 将数据封装成map集合并返回
        HashMap<String, Object> map = new HashMap<>();
        map.put("teacherDetail", teacher);
        map.put("eduCourseList", eduCourseList);
        return map;
    }
}
