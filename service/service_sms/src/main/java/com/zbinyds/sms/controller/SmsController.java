package com.zbinyds.sms.controller;

import com.zbinyds.R;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import com.zbinyds.sms.service.SmsService;
import com.zbinyds.sms.utils.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author zbinyds
 * @time 2022/09/26 10:59
 */

@Api(tags = "阿里云sms短信服务")
@RestController
@RequestMapping("/edusms/sms")
//@CrossOrigin
public class SmsController {

    @Autowired
    private SmsService smsService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @ApiOperation("发送短信验证码")
    @PostMapping("/send/{phone}")
    public R sendCode(@PathVariable String phone) {
        // 必填参数校验
        if (StringUtils.isEmpty(phone)) throw new QiHangException("20001","请输入您的手机号码！");
        /**
         * 一、首先尝试从redis中获取短信验证码
         */
        String code = redisTemplate.opsForValue().get("code::" + phone);
        if (!StringUtils.isEmpty(code)) return R.success().message("缓存验证码发送成功");

        /**
         * 二、如果redis中获取不到，再调用api发送短信验证码。
         */
        code = RandomUtil.getFourBitRandom(); // 通过工具类生成随机验证码
        // params：用于存放模板中的参数信息。比如验证码、过期时间等
        HashMap<String, Object> params = new HashMap<>();
        params.put("code", code);
        boolean isSuccess = smsService.send(phone, params);
        if (isSuccess) {
            // 将生成的短信验证码存入redis中，有效期为5分钟。
            redisTemplate.opsForValue().set("code::" + phone, code, 5, TimeUnit.MINUTES);
            return R.success().message("验证码发送成功！");
        } else {
            return R.success().message("验证码发送失败！");
        }
    }

}
