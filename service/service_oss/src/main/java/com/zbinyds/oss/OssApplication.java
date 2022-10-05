package com.zbinyds.oss;

import com.zbinyds.oss.utils.OssPropertiesUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zbinyds
 * @time 2022/09/17 14:38
 * <p>
 * SpringBoot-启动类
 * 注意：
 * 启动类上如果不加上 @SpringBootApplication(exclude = DataSourceAutoConfiguration.class)配置，将会报错。
 * 原因在于，父工程中引入了数据源依赖，我们子工程继承了父工程的依赖，所以也将此依赖进行了引入。
 * 解决办法：1、配置项目启动时，不加载数据源自动装配类；2、配置文件中配置数据源相关信息。
 */

// 不加载数据源的自动配置类
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan("com.zbinyds")
public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class, args);
    }
}
