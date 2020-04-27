package com.manu.multimybatisxml;

import com.manu.multimybatisxml.mapper.primary.PrimaryStudentMapper;
import com.manu.multimybatisxml.mapper.secondary.SecondaryStudentMapper;
import com.manu.multimybatisxml.model.Student;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Desc: MultiMyBatisXmlTests
 * @Author: jzman
 * @Date: 2020/4/24 15:56.
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiMyBatisXmlTests {

    @Autowired
    private PrimaryStudentMapper primaryStudentMapper;
    @Autowired
    private SecondaryStudentMapper secondaryStudentMapper;

    @Test
    public void insert(){
        primaryStudentMapper.insertStudent(new Student("Student1","A",10));
        secondaryStudentMapper.insertStudent(new Student("Student2","B",12));
    }
}
