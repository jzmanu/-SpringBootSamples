package com.manu.springbootthymeleaf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * @Desc: I18nConfig
 * @Author: jzman
 * @Date: 2020/3/18 18:13.
 */
@Configuration
public class I18nConfig {

    @Bean
    public LocaleResolver localeResolver (){
        return new SessionLocaleResolver();
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                LocaleChangeInterceptor changeInterceptor = new LocaleChangeInterceptor();
                changeInterceptor.setParamName("lang");
                registry.addInterceptor(changeInterceptor);
            }
        };
    }
}
