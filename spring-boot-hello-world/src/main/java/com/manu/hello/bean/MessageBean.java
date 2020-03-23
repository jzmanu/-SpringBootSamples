package com.manu.hello.bean;

/**
 * @Desc: MessageBean
 * @Author: jzman
 * @Date: 2020/3/6 15:51.
 */
public class MessageBean {
    private long id;
    private String author;
    private String message;

    public MessageBean(long id, String author, String info) {
        this.id = id;
        this.author = author;
        this.message = info;
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }
}
