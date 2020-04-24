package com.manu.mybatisxml.mapper;

import com.manu.mybatisxml.model.Class;
import com.manu.mybatisxml.model.Student;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Desc: StudentMapper
 * @Author: jzman
 * @Date: 2020/4/15 17:25.
 */

/**
 * ClassMapper.xml对应的Mapper接口
 */
//@Mapper
public interface ClassMapper {
    /**
     * 插入一条数据
     * @param student student
     */
    void insertStudent(Student student);

    void insertClass(Class course);

    /**
     * 根据sno删除一条记录
     * @param sno sno
     */
    void deleteStudent(String sno);

    /**
     * 更新数据
     * @param student student
     */
    void updateStudent(Student student);

    /**
     * 更具名称查询数据
     * @param name name
     * @return
     */
    Student findStudentByName(String name);

    /**
     * 查询全部数据
     * @return
     */
    List<Student> findAllStudent();

    /**
     * 集合数据查询
     * @param name name
     * @return
     */
    Class findClassStudents(String name);

    /**
     * 集合数据嵌套查询
     * @param classId classId
     * @return
     */
    Class findClassStudents1(String classId);
}
