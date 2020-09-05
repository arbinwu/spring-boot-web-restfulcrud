package com.arbin.springbootwebrestfulcrud.config;

import com.arbin.springbootwebrestfulcrud.component.LoginHandlerInterceptor;
import com.arbin.springbootwebrestfulcrud.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 定制和扩展 MVC
 */
@Configuration
public class MyMvcConfig {

    //所有的WebMvcConfigurerAdapter 组件会一起起作用
    @Bean   //将组件注册在容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //首页的视图映射
                registry.addViewController("/").setViewName("login");
                registry.addViewController("index.html").setViewName("login");

                //main.html 视图映射至dashboard,为了重定向
                registry.addViewController("main.html").setViewName("dashboard");
            }

            /**
             * 注册拦截器
             * @param registry
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //拦截任意路径下的任意请求
                //也可以排除某些请求
                //springboot 已经做完了静态资源映射，不需要在处理
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login","/webjars/**","/asserts/**","/static/**");
//                super.addInterceptors(registry);
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
