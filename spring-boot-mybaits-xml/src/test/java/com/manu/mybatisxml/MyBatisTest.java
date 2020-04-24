package com.manu.mybatisxml;

import com.manu.mybatisxml.mapper.ClassMapper;
import com.manu.mybatisxml.model.Class;
import com.manu.mybatisxml.model.Student;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: MyBatisTest
 * @Author: jzman
 * @Date: 2020/4/16 10:31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ClassMapper mClassMapper;

    @Test
    public void insert() {
        Class class1 = new Class("class1", "一班");
        Class class2 = new Class("class2", "二班");
        mClassMapper.insertClass(class1);
        mClassMapper.insertClass(class2);

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student;
            if (i % 2 == 0) {
                student = new Student("class1", "sno" + i, "Student" + i, "A");
            } else {
                student = new Student("class2", "sno" + i, "Student" + i, "B");
            }
            mClassMapper.insertStudent(student);
        }
    }

    @Test
    public void deleteStudentBySno() {
        mClassMapper.deleteStudent("sno0");
    }

    @Test
    public void updateStudent() {
        Student student = new Student("class1", "sno1", "student1", "C");
        mClassMapper.updateStudent(student);
    }

    @Test
    public void findStudentByName() {
        Student student = mClassMapper.findStudentByName("student5");
        System.out.println(student);
    }

    @Test
    public void findAllStudent() {
        List<Student> students = mClassMapper.findAllStudent();
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void findClassStudents() {
        Class clazz = mClassMapper.findClassStudents("一班");
        System.out.println(clazz.toString());
        System.out.println("classId:" + clazz.getClassId() + ",name:" + clazz.getName());

        List<Student> students = clazz.getStudents();
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void findClassStudents1() {
        Class clazz = mClassMapper.findClassStudents1("class1");
        System.out.println(clazz.toString());
        System.out.println("classId:" + clazz.getClassId() + ",name:" + clazz.getName());

        List<Student> students = clazz.getStudents();
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
