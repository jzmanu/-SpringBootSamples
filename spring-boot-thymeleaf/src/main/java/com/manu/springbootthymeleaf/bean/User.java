package com.manu.springbootthymeleaf.bean;

/**
 * @Desc:
 * @Author: jzman
 * @Date: 2020/3/24 9:48.
 */
public class User {
    private long userId;
    private String username;

    public User() {
    }

    public User(String name) {
        this.username = name;
    }

    public User(long userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}
