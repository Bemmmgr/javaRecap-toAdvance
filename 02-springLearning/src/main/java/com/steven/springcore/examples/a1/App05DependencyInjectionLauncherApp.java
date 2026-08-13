package com.steven.springcore.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// constructor injection / setter injection / field injection
/*Constructor Injection：依赖在对象创建时就必须传入。
 *Setter Injection：对象可以先创建，之后再把依赖设置进去。*/
@Component
class BusinessClass {
    Dependency1 dependency1;
    Dependency2 dependency2;

    /*  public void constructDependency(Dependency1 dependency1, Dependency2 dependency2) {
        super();
        System.out.println("Constructing dependency: ");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    } */

    @Autowired
    public void setDependency1(Dependency1 dependency1) {
        System.out.println("setDependency1: ");
        this.dependency1 = dependency1;
    }

    @Autowired
    public void setDependency2(Dependency2 dependency2) {
        System.out.println("setDependency2: ");
        this.dependency2 = dependency2;
    }

    public String toString() {
        return dependency1 + " and " + dependency2;
    }
}

@Component
class Dependency1 {
}

@Component
class Dependency2 {
}

@Configuration
@ComponentScan
public class App05DependencyInjectionLauncherApp {

    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext(App05DependencyInjectionLauncherApp.class)) {

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BusinessClass.class));
        }
    }
}
