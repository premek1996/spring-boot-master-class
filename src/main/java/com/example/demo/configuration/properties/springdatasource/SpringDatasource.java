package com.example.demo.configuration.properties.springdatasource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Getter
@Setter
@ToString
public class SpringDatasource {

    private String url;
    private String driverClassName;
    private String username;
    private String password;
}
