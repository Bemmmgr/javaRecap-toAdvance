package com.steven.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02GamingBasicJava {
    public static void main(String[] args) {
        // launch a spring context
        var context = new AnnotationConfigApplicationContext(HelloSpringConfigration.class);

        // configure things we want spring to manage - @Configuration - HelloSpringConfigration

        // retrieve beans managed by Spring
        System.out.println(context.getBean("name"));

    }
}
