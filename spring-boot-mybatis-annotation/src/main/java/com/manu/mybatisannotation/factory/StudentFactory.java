package com.manu.mybatisannotation.factory;

import com.manu.mybatisannotation.model.Student;

import org.apache.ibatis.jdbc.SQL;

/**
 * @Desc:
 * @Author: jzman
 * @Date: 2020/4/29 10:18.
 */
public class StudentFactory {
    public String insert1(Student student) {
        String sql = new SQL() {{
            INSERT_INTO("mybatis_student");
            VALUES("sno", "#{sno}");
            VALUES("userName", "#{name}");
            VALUES("grade", "#{grade}");
        }}.toString();
        System.out.println("SQL:" + sql);
        return sql;
    }

    public String insert2(String sno,String name,String grade) {
        String sql = new SQL() {{
            INSERT_INTO("mybatis_student");
            VALUES("sno", "#{sno}");
            VALUES("userName", "#{name}");
            VALUES("grade", "#{grade}");
        }}.toString();
        System.out.println("SQL:" + sql);
        return sql;
    }
}
