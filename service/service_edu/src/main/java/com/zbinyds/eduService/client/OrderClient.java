package com.zbinyds.eduService.client;

import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author zbinyds
 * @time 2022/09/30 22:06
 *
 * 远程调用service-order微服务中的接口
 */

@FeignClient(value = "service-order",fallback = OrderClientHystrix.class)
public interface OrderClient {

    @ApiOperation("付费课程是否被购买")
    @PostMapping("/eduOrder/order/isBuyCourse/{courseId}/{memberId}")
    Boolean isBuyCourse(@PathVariable("courseId") String courseId, @PathVariable("memberId") String memberId);
}
