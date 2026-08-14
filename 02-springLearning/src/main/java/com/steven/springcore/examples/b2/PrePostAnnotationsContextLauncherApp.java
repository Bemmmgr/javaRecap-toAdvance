package com.steven.springcore.examples.b2;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*
@PostConstruct - Bean 创建完成、依赖注入完成后执行一次。 Bean 准备好以后，自动执行一次
@PreDestroy - Bean 被 Spring 销毁前执行一次。 Bean 要被销毁以前，自动执行一次
* */

@Component
class SomeClass {
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All dependencies are ready");
    }

    @PostConstruct
    public void initialize() {
        someDependency.getReady();
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Clean up");
    }
}

@Component
class SomeDependency {
    public void getReady() {
        System.out.println("SomeDependency is ready");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApp {

    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApp.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
