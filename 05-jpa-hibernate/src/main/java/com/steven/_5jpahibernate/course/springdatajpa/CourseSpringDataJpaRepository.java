package com.steven._5jpahibernate.course.springdatajpa;

import com.steven._5jpahibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    // custom method
    List<Course> findByName(String name);
}
