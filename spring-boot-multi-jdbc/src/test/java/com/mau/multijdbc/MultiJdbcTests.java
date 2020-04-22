package com.mau.multijdbc;

import com.mau.multijdbc.bean.Student;
import com.mau.multijdbc.repository.IStudentRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Desc:
 * @Author: jzman
 * @Date: 2020/4/22 15:00.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiJdbcTests {
    @Autowired
    public JdbcTemplate primaryJdbcTemplate;
    @Autowired
    public JdbcTemplate secondaryJdbcTemplate;
    @Autowired
    public IStudentRepository mStudentRepository;

    @Test
    public void insert() {
        Student student = new Student("test", "111", 12);
        mStudentRepository.insert(primaryJdbcTemplate, student);
    }
}
