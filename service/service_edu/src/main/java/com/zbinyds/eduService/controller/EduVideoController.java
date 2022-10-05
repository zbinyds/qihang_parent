package com.zbinyds.eduService.controller;

import com.zbinyds.R;
import com.zbinyds.eduService.pojo.EduVideo;
import com.zbinyds.eduService.service.EduVideoService;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-19
 */

@Api(tags = "小节管理")
@RestController
@RequestMapping("/eduService/video")
//@CrossOrigin
public class EduVideoController {

    @Autowired
    private EduVideoService videoService;

    @ApiOperation("添加小节")
    @PostMapping
    public R save(@RequestBody EduVideo video) {
        // 必填参数校验
        if (StringUtils.isEmpty(video.getChapterId()) &&
                StringUtils.isEmpty(video.getChapterId()) &&
                StringUtils.isEmpty(video.getTitle())){
            throw new QiHangException("20001","必填参数缺失！");
        }
        videoService.save(video);
        return R.success().message("添加小节成功！");
    }

    @ApiOperation("删除小节及对应的视频")
    @DeleteMapping("/{id}")
    public R delete(@PathVariable String id) {
        // 必填参数校验
        if (StringUtils.isEmpty(id)) throw new QiHangException("20001","必填参数缺失！");
        Boolean isSuccess = videoService.removeAlyVodAndVideo(id);
        return isSuccess ? R.success().message("删除小节成功！") : R.failed().message("删除小节失败！");
    }

    @ApiOperation("修改小节")
    @PutMapping
    public R update(@RequestBody EduVideo video) {
        // 必填参数校验
        if (StringUtils.isEmpty(video.getChapterId()) &&
                StringUtils.isEmpty(video.getChapterId()) &&
                StringUtils.isEmpty(video.getTitle()) &&
                StringUtils.isEmpty(video.getId())){
            throw new QiHangException("20001","必填参数缺失！");
        }
        videoService.updateById(video);
        return R.success().message("修改小节成功！");
    }

    @ApiOperation("根据id获取小节")
    @GetMapping("/{id}")
    public R getVideoById(@PathVariable String id) {
        // 必填参数校验
        if (StringUtils.isEmpty(id)) throw new QiHangException("20001","必填参数缺失！");
        EduVideo video = videoService.getById(id);
        return R.success().data("video", video);
    }
}

