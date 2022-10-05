package com.zbinyds.eduService.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zbinyds.eduService.pojo.EduComment;
import com.zbinyds.eduService.mapper.EduCommentMapper;
import com.zbinyds.eduService.service.EduCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-29
 */
@Service
public class EduCommentServiceImpl extends ServiceImpl<EduCommentMapper, EduComment> implements EduCommentService {

    @Override
    public Map<String, Object> pageComment(Page<EduComment> commentPage, String courseId) {
        // 获取该课程的评论信息并分页展示
        LambdaQueryWrapper<EduComment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EduComment::getCourseId,courseId);
        queryWrapper.orderByDesc(EduComment::getGmtCreate);
        IPage<EduComment> page = this.page(commentPage, queryWrapper);

        // 将数据进行封装
        HashMap<String, Object> map = new HashMap<>();
        map.put("items",page.getRecords()); // 评论列表
        map.put("current",page.getCurrent()); // 当前页
        map.put("pages",page.getPages()); // 总页数
        map.put("total",page.getTotal()); // 总记录数
        map.put("size",page.getSize()); // 页记录数
        return map;
    }
}
