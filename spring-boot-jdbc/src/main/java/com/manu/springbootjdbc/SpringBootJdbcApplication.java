package com.manu.springbootjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {

    @Resource
    private JdbcTemplate mJdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 自动创建表
//        mJdbcTemplate.execute("DROP TABLE IF EXISTS `users`;" +
//                "CREATE TABLE `users` (" +
//                "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id'," +
//                "  `name` varchar(32) DEFAULT NULL COMMENT '用户名'," +
//                "  `password` varchar(32) DEFAULT NULL COMMENT '密码'," +
//                "  `age`  int DEFAULT NULL," +
//                "  PRIMARY KEY (`id`)" +
//                ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8; ");
    }
}
