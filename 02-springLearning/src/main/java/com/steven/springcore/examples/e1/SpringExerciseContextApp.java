package com.steven.springcore.examples.e1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class SpringExerciseContextApp {

    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext(SpringExerciseContextApp.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BusinessCalService.class).findMax());
        }
    }
}
