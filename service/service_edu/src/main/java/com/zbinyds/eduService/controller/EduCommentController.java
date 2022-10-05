package com.zbinyds.eduService.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zbinyds.R;
import com.zbinyds.eduService.pojo.EduComment;
import com.zbinyds.eduService.service.EduCommentService;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 评论 前端控制器
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-29
 */

@Api(tags = "课程评论管理")
@RestController
@RequestMapping("/eduService/comment")
//@CrossOrigin
public class EduCommentController {

    @Autowired
    private EduCommentService commentService;

    @ApiOperation("分页获取课程评论")
    @GetMapping("/getCommentList/{courseId}/{page}/{pageSize}")
    public R commentListPage(@PathVariable String courseId, @PathVariable Integer page, @PathVariable Integer pageSize) {
        // 参数非空校验
        if (StringUtils.isEmpty(courseId) || (Objects.isNull(page) || page == 0) || (Objects.isNull(pageSize) || pageSize == 0))
            throw new QiHangException("20001", "必填参数异常！");
        Page<EduComment> commentPage = new Page(page, pageSize);
        Map<String, Object> map = commentService.pageComment(commentPage, courseId);
        return !Objects.isNull(map) ? R.success().message("请求成功！").data(map) : R.failed().message("请求失败！");
    }

    @ApiOperation("发表评论")
    @PostMapping("/saveComment")
    public R saveComment(@RequestBody EduComment comment){
        // 参数合法性校验
        if (Objects.isNull(comment) || StringUtils.isEmpty(comment.getMemberId()) || StringUtils.isEmpty(comment.getContent()))
            throw new QiHangException("20001","请输入您的评论内容！");
        boolean save = commentService.save(comment);
        return save ? R.success().message("感谢您对该课程的评价~") : R.failed().message("您的评论失败，请重试！");
    }
}

