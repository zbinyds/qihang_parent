package com.zbinyds.vod.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import com.zbinyds.vod.service.VodService;
import com.zbinyds.vod.utils.InitVodClient;
import com.zbinyds.vod.utils.VodPropertiesUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zbinyds
 * @time 2022/09/22 16:31
 * <p>
 * service层 实现类
 */

@Service
@Slf4j
public class VodServiceImpl implements VodService {

    @Override
    public String uploadVideo(MultipartFile file) {
        // 获取文件流
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            // 获取原文件名
            String fileName = file.getOriginalFilename();
            // 上传之后视频显示的名称
            String title = fileName.substring(0, fileName.lastIndexOf("."));

            // 构造上传视频的请求对象
            UploadStreamRequest request = new UploadStreamRequest(VodPropertiesUtils.KEY_ID, VodPropertiesUtils.KEY_SECRET, title, fileName, inputStream);
            /* 是否使用默认水印（可选），指定模板组ID时，根据模板组配置确定是否使用默认水印*/
            request.setShowWaterMark(true);

            // 上传器对象-通过uploadStream流的方式发送上传请求
            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request); // 请求响应对象
            String videoId = response.getVideoId(); // 获取视频id
            // 如果上传视频中途发生异常
            if (!response.isSuccess()) {
                String errorMessage = "阿里云上传错误：" + "code：" + response.getCode() + ", message：" + response.getMessage();
                log.warn(errorMessage);
                if (StringUtils.isEmpty(videoId)) {
                    throw new QiHangException("20001", errorMessage);
                }
            }
            return videoId;
        } catch (IOException e) {
            e.printStackTrace();
            throw new QiHangException("20001", "获取视频文件流异常！");
        }
    }

    @Override
    public void deleteVideo(String videoId) {
        try {
            // 初始化client对象
            DefaultAcsClient client = InitVodClient.initVodClient(VodPropertiesUtils.KEY_ID, VodPropertiesUtils.KEY_SECRET);
            // 构建request请求对象
            DeleteVideoRequest request = new DeleteVideoRequest();
            request.setVideoIds(videoId);
            // 通过client对象，发送删除视频的请求
            client.getAcsResponse(request);
            log.info("===========删除视频成功===========");
        } catch (Exception e) {
            throw new QiHangException("20001", "删除视频失败！");
        }
    }

    @Override
    public void deleteVideoBatch(List<String> videoIdList) {
        try {
            // 初始化client对象
            DefaultAcsClient client = InitVodClient.initVodClient(VodPropertiesUtils.KEY_ID, VodPropertiesUtils.KEY_SECRET);
            // 构建request请求对象
            DeleteVideoRequest request = new DeleteVideoRequest();
            // 将videoList按照逗号分隔转成String类型
            String videoIds = String.join(",", videoIdList);
            // 将要删除的视频id设置到request对象中
            request.setVideoIds(videoIds);
            // 通过client对象，发送删除视频的请求
            client.getAcsResponse(request);
            log.info("===========删除视频成功===========");
        } catch (Exception e) {
            throw new QiHangException("20001", "删除视频失败！");
        }
    }

    @Override
    public String getPlayAuth(String id) {
        // 获取请求响应
        try {
            // 创建初始化对象
            DefaultAcsClient client = InitVodClient.initVodClient(VodPropertiesUtils.KEY_ID, VodPropertiesUtils.KEY_SECRET);
            // 创建获取地址的request和response对象
            GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
            GetVideoPlayAuthResponse response = new GetVideoPlayAuthResponse();

            // 将阿里云视频id设置到请求内
            request.setVideoId(id);
            response = client.getAcsResponse(request);
            // 获取视频播放凭证
            String playAuth = response.getPlayAuth();
            log.info("视频播放凭证为：" + playAuth);
            return playAuth;
        } catch (ClientException e) {
            e.printStackTrace();
            throw new QiHangException("20001", "获取视频播放凭证发生了异常！");
        }
    }


    /**
     * 测试
     */
    @Test
    public void test() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        String join = String.join(",", strings);
        System.out.println(strings);
        System.out.println(join);
    }
}
