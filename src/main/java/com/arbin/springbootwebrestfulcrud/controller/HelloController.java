package com.arbin.springbootwebrestfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    /*
        查找一些数据 在页面战士
     */
    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "你好");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "success";
    }
}
