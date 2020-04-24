package com.mau.multijdbc.repository;

import com.mau.multijdbc.bean.Student;

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

    public JdbcTemplate primaryJdbcTemplate;

    /**
     * 构造方法自动装配
     *
     * @param primaryJdbcTemplate primaryJdbcTemplate
     */
    public StudentRepositoryImpl(JdbcTemplate primaryJdbcTemplate) {
        this.primaryJdbcTemplate = primaryJdbcTemplate;
    }

    @Override
    public void insert(JdbcTemplate jdbcTemplate, Student student) {

        if (jdbcTemplate == null){
            jdbcTemplate = primaryJdbcTemplate;
        }

        jdbcTemplate.update("INSERT INTO student(name,grade,age) values(?,?,?) ",
                student.getName(), student.getGrade(), student.getAge());
    }

    @Override
    public void delete(long id) {

        primaryJdbcTemplate.update("DELETE FROM student where id=?", id);
    }

    @Override
    public void update(Student student) {
        primaryJdbcTemplate.update("UPDATE student SET name=?,grade=?,age=? WHERE id=?",
                student.getName(), student.getGrade(), student.getAge(), student.getId());
    }

    @Override
    public Student findByName(String name) {
        Object[] args = {name};
        return primaryJdbcTemplate.queryForObject("SELECT * FROM student WHERE name=?", args,
                new BeanPropertyRowMapper<Student>(Student.class));
    }

    @Override
    public List<Student> findAll() {
        return primaryJdbcTemplate.query("SELECT * FROM student",new BeanPropertyRowMapper<>(Student.class));
    }

    public static class StudentRowMapper implements RowMapper<Student>{

        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setName(rs.getString("name"));
            student.setGrade(rs.getString("grade"));
            student.setAge(rs.getInt("age"));
            return student;
        }
    }
}


