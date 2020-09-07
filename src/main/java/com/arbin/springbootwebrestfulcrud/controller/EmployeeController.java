package com.arbin.springbootwebrestfulcrud.controller;

import com.arbin.springbootwebrestfulcrud.dao.EmployeeDao;
import com.arbin.springbootwebrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中 用于前端取出数据展示 list.html
        model.addAttribute("emps",employees);
//        System.out.print();
        // thymeleat 会默认进行拼串
        // classpath:/template/xxxx.html
        return "emp/list";
    }
}
