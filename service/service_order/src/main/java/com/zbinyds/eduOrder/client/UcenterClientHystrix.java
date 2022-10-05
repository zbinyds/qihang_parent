package com.zbinyds.eduOrder.client;

import com.zbinyds.R;
import com.zbinyds.orderVo.MemberOrder;
import org.springframework.stereotype.Component;

/**
 * @author zbinyds
 * @time 2022/09/29 21:19
 */

@Component
public class UcenterClientHystrix implements UcenterClient{

    @Override
    public MemberOrder getMemberOrder(String memberId) {
        return null;
    }
}
