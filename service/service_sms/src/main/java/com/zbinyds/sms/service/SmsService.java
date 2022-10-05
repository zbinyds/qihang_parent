package com.zbinyds.sms.service;

import java.util.HashMap;

/**
 * @author zbinyds
 * @time 2022/09/26 11:03
 */

public interface SmsService {
    /**
     * 发送短信验证码
     * @param phone:手机号
     * @param params：验证码、过期时间等相关信息
     * @return：是否发送成功
     */
    boolean send(String phone, HashMap<String, Object> params);
}
