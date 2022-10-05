package com.zbinyds.vod.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zbinyds
 * @time 2022/09/22 17:14
 *
 * 常量类-获取阿里云VOD服务的相关配置信息
 */

@Component
public class VodPropertiesUtils implements InitializingBean {

    // 读取配置文件中配置
    @Value("${aliyun.vod.file.keyId}")
    private String keyid;
    @Value("${aliyun.vod.file.keySecret}")
    private String keysecret;

    public static String KEY_ID;
    public static String KEY_SECRET;

    @Override
    public void afterPropertiesSet() throws Exception {
        KEY_ID = keyid;
        KEY_SECRET = keysecret;
    }
}
