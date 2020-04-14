package com.manu.springbootjdbc.controller;

import com.manu.springbootjdbc.bean.Student;
import com.manu.springbootjdbc.repository.IStudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Desc:
 * @Author: jzman
 * @Date: 2020/4/9 9:18.
 */
@RestController
class StudentController {
    @Resource
    IStudentRepository mStudentRepository;

    @GetMapping("/find")
    public String save() {
        Student student = mStudentRepository.findByName("jzman");
        return student.toString();
    }
}
