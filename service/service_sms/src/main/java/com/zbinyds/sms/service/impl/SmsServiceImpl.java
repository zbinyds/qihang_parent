package com.zbinyds.sms.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.zbinyds.sms.service.SmsService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;

/**
 * @author zbinyds
 * @time 2022/09/26 11:03
 */

@Service
public class SmsServiceImpl implements SmsService {

    @Override
    public boolean send(String phone, HashMap<String, Object> params) {
        // 参数非空校验
        if (StringUtils.isEmpty(phone)) return false;

        // 构造client用于发送请求
        DefaultProfile profile =
                DefaultProfile.getProfile("default", "LTAI5t94ua4j9W5mp24sP9WT", "yRzxmVz0ZhvaeLHn0qvzKLqj1r08fE");
        IAcsClient client = new DefaultAcsClient(profile);

        // 固定配置
        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        // 配置请求参数
        request.putQueryParameter("PhoneNumbers", phone); // 手机号
        request.putQueryParameter("SignName", "阿里云短信测试"); // 签名名称
        request.putQueryParameter("TemplateCode", "SMS_154950909"); // 模板code
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(params)); // 参数（可传入验证码、过期时间等）

        try {
            // 发送短信验证码
            CommonResponse response = client.getCommonResponse(request);
            System.out.println("请求响应信息：" + response.getData());
            return response.getHttpResponse().isSuccess(); // 是否成功发送
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }
}
