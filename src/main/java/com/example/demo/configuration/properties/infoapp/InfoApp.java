package com.example.demo.configuration.properties.infoapp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "info.app")
@Getter
@Setter
@ToString
public class InfoApp {

    private String name;
    private String description;
    private String version;

}
