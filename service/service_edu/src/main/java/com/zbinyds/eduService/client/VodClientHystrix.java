package com.zbinyds.eduService.client;

import com.zbinyds.R;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zbinyds
 * @time 2022/09/23 18:17
 *
 * 熔断器。请求目标服务中接口时服务宕机，执行的方法。
 */

@Component
public class VodClientHystrix implements VodClient{
    @Override
    public R removeVideo(String videoId) {
        return R.failed().message("请求失败！目标服务器状态异常！");
    }

    @Override
    public R removeVideoBatch(List<String> videoIdList) {
        return R.failed().message("请求失败！目标服务器状态异常！");
    }
}
