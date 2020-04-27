package com.manu.multimybatisxml.model;

/**
 * @Desc: Student
 * @Author: jzman
 * @Date: 2020/3/27 14:37.
 */
public class Student {
    private long id;
    private String name;
    private String grade;
    private int age;

    public Student() {
    }

    public Student(String name, String grade, int age) {
        this.name = name;
        this.grade = grade;
        this.age = age;
    }

    public Student(long id, String name, String grade, int age) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String password) {
        this.grade = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", age=" + age +
                '}';
    }
}
