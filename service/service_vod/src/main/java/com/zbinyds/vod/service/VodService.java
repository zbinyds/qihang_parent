package com.zbinyds.vod.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author zbinyds
 * @time 2022/09/22 16:30
 *
 * service层
 */
public interface VodService {
    /**
     * 上传视频
     * @param file：视频对象
     * @return：返回视频id。
     */
    String uploadVideo(MultipartFile file);

    /**
     * 删除视频
     * @param videoId：阿里云视频id
     */
    void deleteVideo(String videoId);

    /**
     * 批量删除视频
     * @param videoList：视频id集合
     */
    void deleteVideoBatch(List<String> videoList);

    /**
     * 根据阿里云视频id获取它的播放凭证
     * @param id：阿里云视频id
     * @return：凭证字符串
     */
    String getPlayAuth(String id);
}
