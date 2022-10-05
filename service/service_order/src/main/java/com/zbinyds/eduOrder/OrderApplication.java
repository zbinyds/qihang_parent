package com.zbinyds.eduOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zbinyds
 * @time 2022/09/29 19:11
 */

@SpringBootApplication
@ComponentScan("com.zbinyds")
@EnableFeignClients // 调用端声明
@EnableTransactionManagement // 开启事务管理器
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
