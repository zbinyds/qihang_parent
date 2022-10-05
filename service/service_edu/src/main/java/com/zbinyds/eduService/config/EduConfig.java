package com.zbinyds.eduService.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zbinyds
 * @time 2022/09/13 16:24
 *
 * 配置类
 */

@Configuration
@MapperScan("com.zbinyds.eduService.mapper") // mapper包扫描路径
public class EduConfig {

    /**
     * 逻辑删除插件。（mybatis-plus版本 >= 3.1.1之后不用配置此项）
     *
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    /**
     * Mybatis-plus分页插件。（mybatis-plus高版本，配置的是 MybatisPlusInterceptor）
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
