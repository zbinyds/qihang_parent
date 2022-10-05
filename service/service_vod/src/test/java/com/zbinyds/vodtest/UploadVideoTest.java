package com.zbinyds.vodtest;
import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author zbinyds
 * @time 2022/09/22 12:01
 */

public class UploadVideoTest {
    //账号AK信息请填写（必选）
    private static final String accessKeyId = "LTAI5t94ua4j9W5mp24sP9WT";
    //账号AK信息请填写（必选）
    private static final String accessKeySecret = "yRzxmVz0ZhvaeLHn0qvzKLqj1r08fE";

    // 视频文件上传
    public static void main(String[] args) {
        // 视频标题(必选)
        String title = "测试上传视频";
        // 1.本地文件上传和文件流上传时，文件名称为上传文件绝对路径，如:/User/sample/文件名称.mp4 (必选)
        // 2.网络流上传时，文件名称为源文件名，如文件名称.mp4(必选)。
        // 3.流式上传时，文件名称为源文件名，如文件名称.mp4(必选)。
        // 任何上传方式文件名必须包含扩展名
        String fileName = "E:\\uploadVideo\\upload.mp4";

        // 4.流式上传，如文件流和网络流
        InputStream inputStream = null;
        // 4.1 文件流
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        testUploadStream(accessKeyId, accessKeySecret, title, fileName, inputStream);

    }

    /**
     * 流式上传视频接口
     *
     * @param accessKeyId：阿里云AccessKey
     * @param accessKeySecret：秘钥
     * @param title：视频名
     * @param fileName：
     * @param inputStream
     */
    private static void testUploadStream(String accessKeyId, String accessKeySecret, String title, String fileName, InputStream inputStream) {
        UploadStreamRequest request = new UploadStreamRequest(accessKeyId, accessKeySecret, title, fileName, inputStream);
        /* 是否使用默认水印（可选），指定模板组ID时，根据模板组配置确定是否使用默认水印*/
        request.setShowWaterMark(true);

        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadStreamResponse response = uploader.uploadStream(request);
        System.out.print("RequestId=" + response.getRequestId() + "\n");  //请求视频点播服务的请求ID
        if (response.isSuccess()) {
            System.out.print("VideoId=" + response.getVideoId() + "\n");
        } else { //如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因
            System.out.print("VideoId=" + response.getVideoId() + "\n");
            System.out.print("ErrorCode=" + response.getCode() + "\n");
            System.out.print("ErrorMessage=" + response.getMessage() + "\n");
        }
    }
}
