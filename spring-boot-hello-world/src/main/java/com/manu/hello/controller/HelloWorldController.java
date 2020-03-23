package com.manu.hello.controller;

import com.manu.hello.bean.MessageBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodType;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Desc: HelloWorldController
 * @Author: jzman
 * @Date: 2020/3/6 14:57.
 */
//@Controller
//@ResponseBody
@RestController
public class HelloWorldController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

//    @RequestMapping(value = "/message", method = RequestMethod.GET)
    @GetMapping("/message")
    public MessageBean message(@RequestParam(name = "author", defaultValue = "default") String author,
                               @RequestParam(name = "message", defaultValue = "default message!") String message) {
        return new MessageBean(counter.incrementAndGet(), author, message);
    }
}
