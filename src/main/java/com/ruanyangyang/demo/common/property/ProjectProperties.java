package com.ruanyangyang.demo.common.property;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:project.properties"})
@ConfigurationProperties(prefix = "tb")
public class ProjectProperties {
    // 加载Shiro配置
    private ShiroProperties shiro = new ShiroProperties();

    // 加载Swagger配置
    private SwaggerProperties swagger = new SwaggerProperties();

}
