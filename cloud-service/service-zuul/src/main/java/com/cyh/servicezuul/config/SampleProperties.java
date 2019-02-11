package com.cyh.servicezuul.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author yunhai.chen
 * @date 2018/8/30 15:21<br>
 * Description:
 **/
@Configuration
@Data
@RefreshScope
public class SampleProperties {
    private String username = "default value";
}
