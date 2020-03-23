package com.manu.springbooti18n.controller;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * @Desc: I18nController
 * @Author: jzman
 * @Date: 2020/3/20 9:42.
 */
@Controller
public class I18nController {
    @Resource
    public MessageSource mMessageSource;

    @GetMapping(value = "/i18n")
    public String il8n() {
        return "i18n";
    }

    @GetMapping(value = "/i18n")
    public String il8n1(Model model) {
        // 读取配置文件中的属性
        String message = mMessageSource.getMessage("home.title", null, LocaleContextHolder.getLocale());
        System.out.println("--message-->" + message);
        return "i18n";
    }
}
