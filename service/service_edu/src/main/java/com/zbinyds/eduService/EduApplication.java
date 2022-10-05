package com.zbinyds.eduService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zbinyds
 * @time 2022/09/13 16:02
 */

@SpringBootApplication
@ComponentScan("com.zbinyds")
@EnableTransactionManagement // 开启事务管理
@EnableFeignClients // 调用端声明
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}
