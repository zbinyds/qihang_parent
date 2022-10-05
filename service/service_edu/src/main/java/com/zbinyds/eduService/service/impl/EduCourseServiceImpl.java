package com.zbinyds.eduService.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbinyds.R;
import com.zbinyds.eduService.client.VodClient;
import com.zbinyds.eduService.mapper.*;
import com.zbinyds.eduService.pojo.*;
import com.zbinyds.eduService.pojo.front_vo.CourseQueryVo;
import com.zbinyds.eduService.pojo.vo.CourseInfoVo;
import com.zbinyds.eduService.pojo.vo.PublishCourseInfoVo;
import com.zbinyds.eduService.service.EduCourseService;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-19
 */
@Service
@Transactional // 开启事务管理
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    private EduCourseDescriptionMapper courseDescriptionMapper;

    @Autowired
    private EduVideoMapper videoMapper;

    @Autowired
    private EduChapterMapper chapterMapper;

    @Autowired
    private EduCommentMapper commentMapper;

    @Autowired
    private VodClient vodClient; // 注入client，实现远程调用service-vod服务中的接口

    @Override
    public String saveCourseInfo(CourseInfoVo courseInfoVo) {
        // 1、将课程基本信息添加到课程表中
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse); // 将表单对象courseInfo，拷贝一份给eduCourse实体类对象
        baseMapper.insert(eduCourse);

        // 2、将该课程的简介信息添加到简介表中
        String courseId = eduCourse.getId(); // 获取课程id
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setId(courseId);
        courseDescription.setDescription(courseInfoVo.getDescription());
        courseDescriptionMapper.insert(courseDescription);

        return courseId;
    }

    @Override
    public CourseInfoVo getCourseInfo(String courseId) {
        CourseInfoVo courseInfoVo = new CourseInfoVo();
        // 1、获取课程基本信息
        EduCourse eduCourse = baseMapper.selectById(courseId);
        BeanUtils.copyProperties(eduCourse, courseInfoVo);

        // 2、获取课程简介
        EduCourseDescription courseDescription = courseDescriptionMapper.selectById(courseId);
        courseInfoVo.setDescription(courseDescription.getDescription());

        return courseInfoVo;
    }

    @Override
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {
        // 1、修改课程基本信息
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);
        int row = baseMapper.updateById(eduCourse); // 受影响的行数

        if (row == 0) {
            throw new QiHangException("20001", "修改课程信息失败！");
        }
        // 2、修改课程简介
        EduCourseDescription description = new EduCourseDescription();
        description.setId(courseInfoVo.getId());
        description.setDescription(courseInfoVo.getDescription());
        courseDescriptionMapper.updateById(description);
    }

    @Override
    public PublishCourseInfoVo getPublishCourseInfo(String courseId) {
        return baseMapper.getPublishCourseInfo(courseId);
    }

    @Override
    public void removeCourse(String courseId) {
        // 1.1、删除该课程中章节小节中的所有视频
        // 根据课程id获取到所有小节对应的视频id（小节中没有视频的，直接过滤）
        LambdaQueryWrapper<EduVideo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EduVideo::getCourseId, courseId);
        queryWrapper.select(EduVideo::getVideoSourceId);
        List<EduVideo> VideoList = videoMapper.selectList(queryWrapper); // 此时为：[EduVideo{id=null,...,VideoSourceId=18,...}]
        List<String> videoIdList = VideoList.stream()
                .filter(video -> !StringUtils.isEmpty(video.getVideoSourceId()))
                .map(EduVideo::getVideoSourceId)
                .collect(Collectors.toList());
        // 当课程中存在视频，才需要级联删除
        if (!videoIdList.isEmpty()){
            // 根据获取的视频id集合，去删除阿里云视频点播中存放的视频信息
            R result = vodClient.removeVideoBatch(videoIdList);
            // 状态码异常，直接抛异常。
            if (!"20000".equals(result.getCode())) throw new QiHangException("20001", result.getMessage());
        }

        // 1.2、删除该课程下的所有小节
        videoMapper.deleteByCourseId(courseId);

        // 1.3、删除该课程下的所有章节
        chapterMapper.deleteByCourseId(courseId);

        // 1.4、删除该课程的简介信息
        courseDescriptionMapper.deleteById(courseId);

        // 1.5、删除课程
        int row = baseMapper.deleteById(courseId);
        // 存在异常的情况
        if (row < 1) throw new QiHangException("20001", "删除课程失败！");
    }

    @Override
    public Map<String,Object> getCourseListPageByCondition(Integer page, Integer pageSize, CourseQueryVo courseQueryVo) {
        Page<EduCourse> coursePage = new Page<>(page, pageSize);

        /**
         * 构建查询条件，进行按需查询。
         */
        LambdaQueryWrapper<EduCourse> queryWrapper = new LambdaQueryWrapper<>();
        // 只有发布了的课程才能被看到
        queryWrapper.eq(EduCourse::getStatus,"Normal");
        // 如果courseQueryVo中包含一级分类id字段（查询该一级分类下的课程）
        queryWrapper.eq(!StringUtils.isEmpty(courseQueryVo.getSubjectParentId()), EduCourse::getSubjectParentId, courseQueryVo.getSubjectParentId());
        // 如果courseQueryVo中包含二级分类id字段（查询该二级分类下的课程）
        queryWrapper.eq(!StringUtils.isEmpty(courseQueryVo.getSubjectId()), EduCourse::getSubjectId, courseQueryVo.getSubjectId());
        // 如果courseQueryVo中包含价格排序字段（按照价格降序排序）
        queryWrapper.orderByDesc(!StringUtils.isEmpty(courseQueryVo.getPriceSort()), EduCourse::getPrice);
        // 如果courseQueryVo包含最新时间排序字段（按照创建时间降序排序）
        queryWrapper.orderByDesc(!StringUtils.isEmpty(courseQueryVo.getGmtCreateSort()), EduCourse::getGmtCreate);
        // 如果courseQueryVo包含销量排序字段（按照销量降序排序）
        queryWrapper.orderByDesc(!StringUtils.isEmpty(courseQueryVo.getBuyCountSort()), EduCourse::getBuyCount);

        /**
         * 进行分页条件查询
         */
        this.page(coursePage, queryWrapper);

        /**
         * 将数据封装到map中，并返回。
         */
        HashMap<String, Object> map = new HashMap<>();
        map.put("items", coursePage.getRecords()); // 课程列表
        map.put("current", coursePage.getCurrent()); // 当前页
        map.put("pages", coursePage.getPages()); // 总页数
        map.put("size", coursePage.getSize()); // 每页记录数
        map.put("total", coursePage.getTotal()); // 总记录数
        map.put("hasNext", coursePage.hasNext()); // 是否存在下一页
        map.put("hasPrevious", coursePage.hasPrevious()); // 是否存在上一页
        return map;
    }

    @Override
    public Map<String, Object> getCourseDetail(String courseId) {
        Map<String, Object> map = baseMapper.getCourseDetail(courseId);
        return map;
    }

    @Override
    public Map<String, Object> getPage(Integer page, Integer pageSize, CourseQueryVo courseQueryVo) {
        Page<Map> mapPage = new Page<>(page, pageSize);
        mapPage = baseMapper.getPage(mapPage,courseQueryVo);

        // 封装返回对象map
        HashMap<String, Object> map = new HashMap<>();
        map.put("items", mapPage.getRecords()); // 课程列表
        map.put("current", mapPage.getCurrent()); // 当前页
        map.put("pages", mapPage.getPages()); // 总页数
        map.put("size", mapPage.getSize()); // 每页记录数
        map.put("total", mapPage.getTotal()); // 总记录数
        map.put("hasNext", mapPage.hasNext()); // 是否存在下一页
        map.put("hasPrevious", mapPage.hasPrevious()); // 是否存在上一页
        return map;
    }
}
