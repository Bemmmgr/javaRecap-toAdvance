package com.steven.springcore.HelloSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloSpring {
    public static void main(String[] args) {
        try (// launch a spring context
             var context = new AnnotationConfigApplicationContext(HelloSpringConfigration.class);
        ) {
            // configure things we want spring to manage - @Configuration - HelloSpringConfigration

            // retrieve beans managed by Spring
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("person"));

            System.out.println(context.getBean("newAddress"));
            // System.out.println(context.getBean(Address.class));     // same

            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println("person4Qualifier");
        }
    }
}
