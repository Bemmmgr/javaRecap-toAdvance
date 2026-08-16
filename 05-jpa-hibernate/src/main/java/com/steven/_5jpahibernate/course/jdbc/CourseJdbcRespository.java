package com.steven._5jpahibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRespository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static final String INSERT_SQL = """
            insert into course (id, name, author)
            values (?, ?, ?)
            """;

    public void insert() {
        // hard coded
        springJdbcTemplate.update(INSERT_SQL, 1L, "AWS", "udemy");
    }
}
