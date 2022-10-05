package com.zbinyds.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zbinyds
 * @time 2022/09/24 14:57
 *
 * 微服务SpringBoot启动类
 */

@SpringBootApplication
@ComponentScan("com.zbinyds")
@EnableTransactionManagement // 开启事务管理器
public class CmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }
}
