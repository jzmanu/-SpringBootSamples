package com.manu.springbootjdbc.repository;

import com.manu.springbootjdbc.bean.Student;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Desc: StudentRepositoryImpl
 * @Author: jzman
 * @Date: 2020/3/27 14:47.
 */
@Repository
public class StudentRepositoryImpl implements IStudentRepository {

    public JdbcTemplate mJdbcTemplate;

    /**
     * 构造方法自动装配
     *
     * @param jdbcTemplate JdbcTemplate
     */
    public StudentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.mJdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Student student) {
        mJdbcTemplate.update("INSERT INTO student(name,password,age) values(?,?,?) ",
                student.getName(), student.getPassword(), student.getAge());
    }

    @Override
    public void delete(long id) {
        mJdbcTemplate.update("DELETE FROM student where id=?", id);
    }

    @Override
    public void update(Student student) {
        mJdbcTemplate.update("UPDATE student SET name=?,password=?,age=? WHERE id=?",
                student.getName(), student.getPassword(), student.getAge(), student.getId());
    }

    @Override
    public Student findByName(String name) {
        Object[] args = {name};
        return mJdbcTemplate.queryForObject("SELECT * FROM student WHERE name=?", args,
                new BeanPropertyRowMapper<Student>(Student.class));
    }

    @Override
    public List<Student> findAll() {
        return mJdbcTemplate.query("SELECT * FROM student",new BeanPropertyRowMapper<>(Student.class));
    }

    public static class StudentRowMapper implements RowMapper<Student>{

        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setName(rs.getString("name"));
            student.setPassword(rs.getString("password"));
            student.setAge(rs.getInt("age"));
            return student;
        }
    }
}


