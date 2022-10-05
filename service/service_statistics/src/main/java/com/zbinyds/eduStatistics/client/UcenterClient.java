package com.zbinyds.eduStatistics.client;

import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author zbinyds
 * @time 2022/10/01 11:49
 */

@FeignClient(value = "service-ucenter",fallback = UcenterClientHystrix.class)
public interface UcenterClient {

    @ApiOperation("查询某日项目注册人数-statistics服务调用")
    @PostMapping("/ucenter/member/getRegisterNum/{date}")
    Integer getRegisterNum(@PathVariable("date") String date);
}
