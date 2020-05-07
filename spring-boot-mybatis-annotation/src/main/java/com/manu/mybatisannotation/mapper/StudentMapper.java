package com.manu.mybatisannotation.mapper;

import com.manu.mybatisannotation.factory.StudentFactory;
import com.manu.mybatisannotation.model.Student;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Desc: StudentMapper
 * @Author: jzman
 * @Date: 2020/4/28 9:59.
 */
@Mapper
public interface StudentMapper {
    /**
     * 注解中的SQL语句中会自动获取对象student的相关属性
     */
    @Insert("INSERT INTO mybatis_student(userName,sno,grade) VALUES(#{name},#{sno},#{grade})")
    void insert(Student student);

    /**
     * StudentFactory中会自动获取对象student的相关属性在SQL语句中
     * StudentFactory中insert2方法通过#{属性名}的方式获取变量值
     */
    @InsertProvider(type = StudentFactory.class, method = "insert1")
    void insert1(Student student);

    /**
     * 直接传递参数
     * StudentFactory中insert2方法通过#{变量名}的方式获取变量值
     * 此外也可以通过StringBuffer拼接SQL，如在insert2方法中拼接SQL字符串返回
     */
    @InsertProvider(type = StudentFactory.class, method = "insert2")
    void insert2(String sno, String name, String grade);

}
