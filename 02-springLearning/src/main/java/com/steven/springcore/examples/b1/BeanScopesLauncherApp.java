package com.steven.springcore.examples.b1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
singleton	一个 Spring 容器中只有一个实例，默认
prototype	每次请求 Bean，都创建一个新实例
*/

@Component
class NormalClass {
}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {
}

@Configuration
@ComponentScan
public class BeanScopesLauncherApp {

    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext(BeanScopesLauncherApp.class)) {
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class)); // same

            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class)); // not same
        }
    }
}
