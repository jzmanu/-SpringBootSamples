package com.manu.thymeleaftemplatelayout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Desc: 模板布局
 * @Author: jzman
 * @Date: 2020/4/7 10:14.
 */
@Controller
public class TemplateController {
    @GetMapping("/home")
    public String template(Model model){
        model.addAttribute("gzh","躬行之");
        model.addAttribute("name","jzman");
        return "home";
    }

    @GetMapping("/list")
    public String list(){
        return "list";
    }

    @GetMapping("/layout")
    public String layout(){
        return "layout";
    }
}
