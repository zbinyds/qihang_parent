package com.zbinyds.eduService.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zbinyds.R;
import com.zbinyds.eduService.pojo.EduCourseCollect;
import com.zbinyds.eduService.service.EduCourseCollectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zbinyds
 * @time 2022/10/04 17:55
 * <p>
 * 用户收藏课程-前端控制器
 */

@Api(tags = "课程收藏接口管理")
@RestController
@RequestMapping("/eduService/collect")
//@CrossOrigin
public class CollectCourseFrontController {

    @Autowired
    private EduCourseCollectService collectService;

    @ApiOperation("收藏课程")
    @PostMapping
    public R collect(@RequestBody EduCourseCollect collect) {
        return collectService.save(collect) ? R.success().message("收藏成功！") : R.failed().message("收藏失败！");
    }

    @ApiOperation("查询课程收藏状态")
    @GetMapping("/{courseId}/{memberId}")
    public R isCollect(@PathVariable String courseId, @PathVariable String memberId) {
        LambdaQueryWrapper<EduCourseCollect> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EduCourseCollect::getCourseId, courseId);
        queryWrapper.eq(EduCourseCollect::getMemberId, memberId);
        int count = collectService.count(queryWrapper);
        return count > 0 ? R.success().message("课程已收藏！") : R.success().message("课程未收藏！");
    }

//    @ApiOperation("取消收藏课程")
//    @DeleteMapping
//    public R notCollect(@RequestBody EduCourseCollect collect) {
//        LambdaQueryWrapper<EduCourseCollect> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(EduCourseCollect::getCourseId, collect.getCourseId());
//        queryWrapper.eq(EduCourseCollect::getMemberId, collect.getMemberId());
//        return collectService.remove(queryWrapper) ? R.success().message("取消收藏成功！") : R.failed();
//    }
}
