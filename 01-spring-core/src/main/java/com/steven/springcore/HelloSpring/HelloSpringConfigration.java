package com.steven.springcore.HelloSpring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {
}

record Address(String address, String city) {
}

@Configuration
public class HelloSpringConfigration {

    @Bean
    public String name() {
        return "HelloSpringConfigration";
    }

    @Bean
    public int age() {
        return 12;
    }

    @Bean
    @Primary
    public Person person() {
        var person = new Person("Steven", 27, new Address("lekker", "Ams"));
        return person;
    }

    // Method call
    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address newAddress) {
        return new Person(name, age, newAddress);
    }

    @Bean
    public Person person4Qualifier(String name, int age, @Qualifier("address2Qualifier") Address address2) {
        return new Person(name, age, address2);
    }

    @Bean(name = "newAddress")
    public Address address() {
        return new Address("Baker Street", "Den Haag");
    }

    @Bean(name = "address")
    @Qualifier("address2Qualifier")
    public Address address2() {
        return new Address("Visser Street", "Den Haag");
    }
}
