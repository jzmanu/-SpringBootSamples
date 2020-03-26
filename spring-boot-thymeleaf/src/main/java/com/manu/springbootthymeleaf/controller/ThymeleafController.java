package com.manu.springbootthymeleaf.controller;

import com.manu.springbootthymeleaf.bean.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: ThymeleafController
 * @Author: jzman
 * @Date: 2020/3/17 17:56.
 */

@Controller
public class ThymeleafController {
    private final static List<User> mUserList = new ArrayList<>();

    static {
        mUserList.add(new User(1, "jzman"));
        mUserList.add(new User(2, "躬行之"));
        mUserList.add(new User(3, "Tom"));
    }

    /**
     * 用于测试@{...}携带参数
     * @param model
     * @param path
     * @return
     */
    @GetMapping("{path}/i18n")
    public String i18n(Model model, @PathVariable String path) {
        model.addAttribute("path", path);
        return "i18n";
    }

    @RequestMapping("/simple")
    public String simple(Model model) {
        // 测试用传值
        model.addAttribute("name", "jzman");
        model.addAttribute("gzh", "<b>躬行之</b>");
        model.addAttribute("user", new User("manu"));
        model.addAttribute("id", "123456");
        model.addAttribute("flag", false);
        model.addAttribute("value", 10);
        // 循环语句测试用
        model.addAttribute("list", mUserList);
        // span标签的id,css内联测试用
        model.addAttribute("idName", "css");
        // css样式中要使用的颜色值,css内联测试用
        model.addAttribute("color", "#FF0000");
        return "expression";
    }

    /**
     * 用于测试@{...}携带参数
     * @param id
     * @return
     */
    @GetMapping("/message")
    public String message(@RequestParam(name = "id", defaultValue = "0") long id) {
        return "message";
    }
}
