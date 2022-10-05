package com.zbinyds.eduService.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zbinyds.eduService.pojo.EduChapter;
import com.zbinyds.eduService.mapper.EduChapterMapper;
import com.zbinyds.eduService.pojo.EduVideo;
import com.zbinyds.eduService.pojo.vo.chapter.ChapterVo;
import com.zbinyds.eduService.pojo.vo.chapter.VideoVo;
import com.zbinyds.eduService.service.EduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbinyds.eduService.service.EduVideoService;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-19
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Autowired
    private EduVideoService videoService;

    @Transactional
    public List<ChapterVo> getChapterAndVideo(String courseId) {
        // 构建需要返回的数据对象
        ArrayList<ChapterVo> list = new ArrayList<>();

        // 获取所有的章节信息
        LambdaQueryWrapper<EduChapter> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EduChapter::getCourseId, courseId);
        List<EduChapter> chapterList = this.list(queryWrapper);

        // 获取每个章节对应的小节
        for (EduChapter chapter : chapterList) {
            String id = chapter.getId(); // 章节id
            LambdaQueryWrapper<EduVideo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(EduVideo::getChapterId, id);
            List<EduVideo> videoList = videoService.list(lambdaQueryWrapper); // 章节对应的小节列表

            // 封装需要返回的小节列表(children属性)
            ArrayList<VideoVo> videoVoList = new ArrayList<>();
            for (EduVideo eduVideo : videoList) {
                videoVoList.add(new VideoVo(eduVideo.getId(), eduVideo.getTitle(), eduVideo.getIsFree(), eduVideo.getVideoSourceId()));
            }
            // 将封装好的一级分类对象进行添加
            list.add(new ChapterVo(chapter.getId(), chapter.getTitle(), videoVoList));
        }
        // 返回封装好的完全体集合（包含所有的课程基本信息）
        return list;
    }

    @Transactional
    public boolean removeChapter(String chapterId) {
        // 判断此章节下是否存在小节
        LambdaQueryWrapper<EduVideo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EduVideo::getChapterId, chapterId);
        int videoCount = videoService.count(queryWrapper); // 查询该章节下的小节数量
        // 如果当前章节下存在小节，不能删除。
        if (videoCount > 0) {
            throw new QiHangException("20001", "该章节下存在小节，不能删除！");
        }
        return removeById(chapterId);
    }
}
