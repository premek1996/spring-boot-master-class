package com.example.demo.configuration;

import com.example.demo.configuration.properties.infoapp.InfoApp;
import com.example.demo.configuration.properties.springdatasource.SpringDatasource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Value("${info.app.name}")
    private String applicationName;

    @Bean
    public CommandLineRunner commandLineRunner(InfoApp infoApp, SpringDatasource springDatasource) {
        return args -> {
            System.out.println("Command line runner");
            System.out.println(applicationName);
            System.out.println(infoApp);
            System.out.println(springDatasource);
        };
    }

}
