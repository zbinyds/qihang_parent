package com.zbinyds.eduOrder.client;

import com.zbinyds.R;
import com.zbinyds.orderVo.MemberOrder;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author zbinyds
 * @time 2022/09/29 21:19
 */
@FeignClient(value = "service-ucenter",fallback = UcenterClientHystrix.class)
public interface UcenterClient {

    @ApiOperation("通过会员id查询会员信息-order服务调用")
    @PostMapping("/ucenter/member/getMemberOrder/{memberId}")
    MemberOrder getMemberOrder(@PathVariable("memberId") String memberId);
}
