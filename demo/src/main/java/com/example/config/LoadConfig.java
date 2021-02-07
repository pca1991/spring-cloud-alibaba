package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadConfig {
    @Bean
    public MailConfig mailConfig(){
        return new MailConfig();
    }
}
