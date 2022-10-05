package com.zbinyds.eduService.client;

import com.zbinyds.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zbinyds
 * @time 2022/09/23 11:13
 *
 * 远程调用注册中心里 service-vod 服务中的接口
 */

// feignClient远程调用。
// value表示调用的服务名，fallback表示调用服务接口失败，会执行实现类VodClientHystrix里的方法--熔断降级。
@FeignClient(value = "service-vod",fallback = VodClientHystrix.class)
public interface VodClient {

    /**
     * 远程调用接口-删除阿里云Vod服务中单个视频
     * @param videoId：视频id
     * @return
     */
    @DeleteMapping("/eduVod/videoVod/removeVideo/{videoId}")
    R removeVideo(@PathVariable("videoId") String videoId);

    /**
     * 远程调用接口-删除阿里云Vod服务中多个视频
     * @param videoIdList ：视频id集合
     * @return
     */
    @DeleteMapping("/eduVod/videoVod/removeVideoBatch")
    R removeVideoBatch(@RequestParam("videoIdList") List<String> videoIdList);
}
