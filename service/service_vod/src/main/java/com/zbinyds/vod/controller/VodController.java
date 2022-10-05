package com.zbinyds.vod.controller;

import com.zbinyds.R;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import com.zbinyds.vod.service.VodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

/**
 * @author zbinyds
 * @time 2022/09/22 16:28
 * <p>
 * 阿里云视频点播-Vod服务-控制层
 */

@Api(tags = "阿里云Vod视频点播服务")
@RestController
@RequestMapping("/eduVod/videoVod")
//@CrossOrigin // 允许跨域访问
public class VodController {

    @Autowired
    private VodService vodService;

    /**
     * 上传视频-阿里云Vod服务
     *
     * @param file：视频文件（不能超过1GB）
     * @return：返回提示信息
     */
    @ApiOperation("上传视频")
    @PostMapping("/uploadVideo")
    public R uploadVideo(MultipartFile file) {
        // 视频大小限制（最大不能超过1GB）
        if (file.getSize() > 1073741824) throw new QiHangException("20001", "视频大小不得超过1GB！");
        String videoId = vodService.uploadVideo(file);
        return !StringUtils.isEmpty(videoId) ? R.success().message("上传视频成功！").data("videoId", videoId) : R.failed().message("上传视频失败！");
    }

    /**
     * 删除视频-删除阿里云中存储的视频（根据视频id删除）
     *
     * @param videoId：视频id
     * @return：返回提示信息
     */
    @ApiOperation("删除视频")
    @DeleteMapping("/removeVideo/{videoId}")
    public R removeVideo(@PathVariable String videoId) {
        // 后端参数校验
        if (StringUtils.isEmpty(videoId)) throw new QiHangException("20001", "必填参数缺失！");
        vodService.deleteVideo(videoId);
        return R.success().message("删除视频成功！");
    }

    /**
     * 批量删除视频
     *
     * @param videoIdList：阿里云视频id集合
     * @return
     */
    @ApiOperation("批量删除视频")
    @DeleteMapping("/removeVideoBatch")
    public R removeVideoBatch(@RequestParam("videoIdList") List<String> videoIdList) {
        // 后端参数校验
        if (Objects.isNull(videoIdList) || videoIdList.size() == 0) throw new QiHangException("20001", "必填参数缺失！");
        vodService.deleteVideoBatch(videoIdList);
        return R.success().message("删除视频成功！");
    }

    @ApiOperation("获取阿里云视频播放凭证")
    @GetMapping("/getVideoAuth/{id}")
    public R getVideoAuth(@PathVariable String id) {
        // 参数非空校验
        if (StringUtils.isEmpty(id)) throw new QiHangException("20001", "必填参数为空！");
        String playAuth = vodService.getPlayAuth(id);
        return R.success().data("playAuth", playAuth);
    }
}
