package com.steven.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloSpringConfigration {

    @Bean
    public String name() {
        return "HelloSpringConfigration";
    }
}
