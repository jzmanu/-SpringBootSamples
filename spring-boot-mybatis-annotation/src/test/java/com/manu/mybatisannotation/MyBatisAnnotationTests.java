package com.manu.mybatisannotation;

import com.manu.mybatisannotation.mapper.StudentMapper;
import com.manu.mybatisannotation.model.Student;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Desc:
 * @Author: jzman
 * @Date: 2020/4/28 10:07.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisAnnotationTests {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    StudentMapper mStudentMapper;

    @Test
    public void insert() {
        Student student = new Student("sno0", "jzman0", "A");
        mStudentMapper.insert(student);
    }

    @Test
    public void insert1() {
        Student student = new Student("sno1", "jzman1", "A");
        mStudentMapper.insert1(student);
    }

    @Test
    public void insert2() {
        Student student = new Student("sno2", "jzman2", "A");
        mStudentMapper.insert2(student.getSno(), student.getName(), student.getGrade());
    }
}
