package com.zbinyds.eduService.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zbinyds.eduService.pojo.EduComment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 评论 服务类
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-29
 */
public interface EduCommentService extends IService<EduComment> {

    /**
     * 根据课程id获取该课程的评论信息并分页
     * @param commentPage：分页对象
     * @param courseId：课程id
     * @return：封装好的分页数据
     */
    Map<String, Object> pageComment(Page<EduComment> commentPage, String courseId);
}
