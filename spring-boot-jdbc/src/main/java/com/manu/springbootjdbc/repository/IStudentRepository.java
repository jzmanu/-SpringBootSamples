package com.manu.springbootjdbc.repository;

import com.manu.springbootjdbc.bean.Student;

import java.util.List;

/**
 * @Desc: StudentRepository
 * @Author: jzman
 * @Date: 2020/3/27 14:47.
 */
public interface IStudentRepository {
    /**
     * 保存数据
     * @param student 单条student记录
     */
    void save(Student student);

    /**
     * 删除数据
     * @param id 学生id
     */
    void delete(long id);

    /**
     * 更新数据
     * @param student 单条student记录
     */
    void update(Student student);

    /**
     * 查询数据
     * @param name 姓名
     * @return 返回单条记录
     */
    Student findByName(String name);

    /**
     * 查询全部数据
     * @return 返回全部记录
     */
    List<Student> findAll();
}
