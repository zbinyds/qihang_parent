package com.zbinyds.rabc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zbinyds
 * @time 2022/10/02 21:59
 * <p>
 * 权限控制。
 */

@SpringBootApplication
@ComponentScan("com.zbinyds")
@MapperScan("com.zbinyds.rabc.mapper")
@EnableTransactionManagement // 开启事务管理器
public class RABCApplication {
    public static void main(String[] args) {
        SpringApplication.run(RABCApplication.class, args);
    }
}
