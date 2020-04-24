package com.manu.mybatisxml.model;

import java.util.List;

/**
 * @Desc: 班级
 * @Author: jzman
 * @Date: 2020/4/17 11:10.
 */
public class Class {
    private String classId;
    private String name;
    private List<Student> students;

    public Class() {
    }

    public Class(String classId, String name) {
        this.classId = classId;
        this.name = name;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId='" + classId + '\'' +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
