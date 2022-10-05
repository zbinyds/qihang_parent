package com.zbinyds.ucenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zbinyds
 * @time 2022/09/26 14:41
 *
 * 微服务启动类
 */

@SpringBootApplication
@ComponentScan("com.zbinyds")
@MapperScan("com.zbinyds.ucenter.mapper")
public class UserCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }
}
