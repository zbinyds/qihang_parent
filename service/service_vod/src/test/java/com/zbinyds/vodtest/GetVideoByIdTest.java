package com.zbinyds.vodtest;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;

import java.util.List;

/**
 * @author zbinyds
 * @time 2022/09/21 23:56
 */
public class GetVideoByIdTest {

    public static void main(String[] args){

    }

    // 根据阿里云视频id获取对应的视频播放凭证
    public static void getVideoAuth() throws ClientException {
        // 创建初始化对象
        DefaultAcsClient client = InitVodObject.initVodClient("LTAI5t94ua4j9W5mp24sP9WT", "yRzxmVz0ZhvaeLHn0qvzKLqj1r08fE");
        // 创建获取地址的request和response对象
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        GetVideoPlayAuthResponse response = new GetVideoPlayAuthResponse();

        // 设置阿里云视频id
        request.setVideoId("e66022d0c46446caa82bf7b74a68f214");
        // 获取请求响应
        response = client.getAcsResponse(request);
        // 获取视频播放凭证
        String playAuth = response.getPlayAuth();
        System.out.println("播放凭证为：" + playAuth);
    }

    // 根据阿里云视频id获取对应的视频播放地址
    public static void getVideoUrl() throws ClientException {
        // 创建初始化对象
        DefaultAcsClient client = InitVodObject.initVodClient("LTAI5t94ua4j9W5mp24sP9WT", "yRzxmVz0ZhvaeLHn0qvzKLqj1r08fE");
        // 创建获取地址的request和response对象
        GetPlayInfoRequest request = new GetPlayInfoRequest();
        GetPlayInfoResponse response = new GetPlayInfoResponse();

        //注意：这里只能获取非加密视频的播放地址
        // 设置阿里云视频id
        request.setVideoId("e66022d0c46446caa82bf7b74a68f214");
        // 获取请求响应
        response = client.getAcsResponse(request);

        List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
        // 播放地址
        for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
            System.out.print("PlayInfo.PlayURL = " + playInfo.getPlayURL() + "\n");
        }
        // Base信息
        System.out.print("VideoBase.Title = " + response.getVideoBase().getTitle() + "\n");
    }
}
