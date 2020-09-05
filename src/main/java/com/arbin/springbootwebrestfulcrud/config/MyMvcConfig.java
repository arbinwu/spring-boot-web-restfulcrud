package com.arbin.springbootwebrestfulcrud.config;

import com.arbin.springbootwebrestfulcrud.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig {
    //所有的WebMvcConfigurerAdapter 组件会一起起作用
    @Bean   //将组件注册在容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("index.html").setViewName("login");
            }
        };
        return adapter;
    }

    //将自己的区域解析器LocaleResolver添加到容器中
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
