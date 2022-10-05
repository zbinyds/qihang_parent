package com.zbinyds.eduService.service;

import com.zbinyds.eduService.pojo.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zbinyds.eduService.pojo.vo.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-19
 */
public interface EduChapterService extends IService<EduChapter> {

    /**
     * 根据课程id查询该课程对应的章节以及小节信息
     * @param courseId：课程id
     * @return：返回前端约定好的json格式，包含该课程所有的章节小节数据。
     */
    List<ChapterVo> getChapterAndVideo(String courseId);

    /**
     * 根据章节id删除对应章节（当章节中包含小节，提示不能够删除）
     * @param chapterId：章节id
     * @return：返回提示，是否删除成功。
     */
    boolean removeChapter(String chapterId);
}
