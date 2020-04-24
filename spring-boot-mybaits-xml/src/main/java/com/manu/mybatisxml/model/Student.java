package com.manu.mybatisxml.model;


/**
 * @Desc: Student
 * @Author: jzman
 * @Date: 2020/3/27 14:37.
 */
public class Student {
    private String classId;
    private String sno;
    private String name;
    private String grade;

    public Student() {
    }

    public Student(String classId, String sno, String name, String grade) {
        this.classId = classId;
        this.sno = sno;
        this.name = name;
        this.grade = grade;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
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

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "classId='" + classId + '\'' +
                ", sno='" + sno + '\'' +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
