package com.steven._5jpahibernate.course;

import com.steven._5jpahibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    // @Autowired
    // private CourseJdbcRespository repository;

    // @Autowired
    // private CourseJpaRepository repository;
    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Cloud", "udemy"));
        repository.save(new Course(2, "AWS", "ranga"));
        repository.save(new Course(3, "Redis", "steven"));
        repository.deleteById(2l);

        System.out.println(repository.findById(3l));

        repository.findAll().forEach(System.out::println);
        System.out.println(repository.count());

        System.out.println(repository.findByName("Redis"));
    }
}
