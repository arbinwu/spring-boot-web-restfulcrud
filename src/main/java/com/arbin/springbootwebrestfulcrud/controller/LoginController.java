package com.arbin.springbootwebrestfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    //    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123".equals(password)) {
            //login success
//            return "dashboard";

            //登录的用户  保存在session中
            session.setAttribute("loginUser", username);

            //为了防止表单重复提交，可以重定向到主页  main.html 视图映射至dashboard
            return "redirect:/main.html";

        } else {
            // login failed
            map.put("msg", "用户名密码错误");
            return "login";
        }

    }
}
