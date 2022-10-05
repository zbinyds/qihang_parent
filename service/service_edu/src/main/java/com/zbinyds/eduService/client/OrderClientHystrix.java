package com.zbinyds.eduService.client;

import org.springframework.stereotype.Component;

/**
 * @author zbinyds
 * @time 2022/09/30 22:07
 */
@Component
public class OrderClientHystrix implements OrderClient{

    @Override
    public Boolean isBuyCourse(String courseId, String memberId) {
        return null;
    }
}
