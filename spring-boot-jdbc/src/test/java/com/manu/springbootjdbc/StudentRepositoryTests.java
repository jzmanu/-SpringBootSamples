package com.manu.springbootjdbc;

import com.manu.springbootjdbc.bean.Student;
import com.manu.springbootjdbc.repository.IStudentRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @Desc: StudentRepositoryTests
 * @Author: jzman
 * @Date: 2020/3/27 16:58.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTests {
    @Autowired
    private IStudentRepository mStudentRepository;

    @Test
    public void testSave(){
        Student student1 = new Student("躬行之", "111",3);
        Student student2 = new Student(2,"jzman", "123",20);
        mStudentRepository.save(student1);
        mStudentRepository.save(student2);
    }

    @Test
    public void testDelete(){
        mStudentRepository.delete(1);
        mStudentRepository.delete(3);
        mStudentRepository.delete(4);
    }

    @Test
    public void testUpdate(){
        Student student = new Student(2,"jzman", "123",20);
        mStudentRepository.update(student);
    }

    @Test
    public void testFindByName(){
        Student student = mStudentRepository.findByName("jzman");
        System.out.println("testFindByName:"+student.toString());
    }

    @Test
    public void testFindAll(){
        List<Student> students = mStudentRepository.findAll();
        for (int i=0; i<students.size();i++){
            System.out.println("testFindAll:"+students.get(i).toString());
        }
    }
}
