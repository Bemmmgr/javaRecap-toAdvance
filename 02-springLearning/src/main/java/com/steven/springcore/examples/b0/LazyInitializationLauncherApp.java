package com.steven.springcore.examples.b0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {

}

@Component
@Lazy
class ClassB {
    private ClassA classA;

    public ClassB(ClassA classA) {
        System.out.println("Some initialization logic");
        this.classA = classA;
    }

    public void doingNothing() {
        System.out.println("Nothing here");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApp {

    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext(LazyInitializationLauncherApp.class)) {

            // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("Initializing of context is completed");
            context.getBean("classB", ClassB.class).doingNothing();
        }
    }
}
