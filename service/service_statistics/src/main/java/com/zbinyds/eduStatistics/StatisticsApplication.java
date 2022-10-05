package com.zbinyds.eduStatistics;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zbinyds
 * @time 2022/10/01 11:22
 *
 * 网站日数据统计-微服务启动器
 */

@SpringBootApplication
@ComponentScan("com.zbinyds")
@MapperScan("com.zbinyds.eduStatistics.mapper")
@EnableFeignClients // 调用端
@EnableTransactionManagement // 启用事务管理器
@EnableScheduling // 开启定时任务
public class StatisticsApplication {
    public static void main(String[] args) {
        SpringApplication.run(StatisticsApplication.class, args);
    }
}
