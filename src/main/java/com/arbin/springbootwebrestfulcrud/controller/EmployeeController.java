package com.arbin.springbootwebrestfulcrud.controller;

import com.arbin.springbootwebrestfulcrud.dao.DepartmentDao;
import com.arbin.springbootwebrestfulcrud.dao.EmployeeDao;
import com.arbin.springbootwebrestfulcrud.entities.Department;
import com.arbin.springbootwebrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中 用于前端取出数据展示 list.html
        model.addAttribute("emps", employees);
//        System.out.print();
        // thymeleat 会默认进行拼串
        // classpath:/template/xxxx.html
        return "emp/list";
    }

    // 访问员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("depts", departments);
        //返回添加页面
        return "emp/add";
    }

    // 员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定 要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        System.out.print(employee);
        System.out.println(employee.getDepartment().getDepartment());
        // birth SpringMVC默认日期格式化为yyyy/mm/dd 可以在配置文件中进行修改
        employeeDao.save(employee);  //save
        // 重定向到员工列表页
        // redirect 重定向到一个地址 /代表当前项目路径  forward 表示转发到一个地址
//        return "/emps";
        return "redirect:/emps";
    }

    // 访问修改页面  查出指定员工 在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        //查出员工路径
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        //查出部门信息,显示所有部门列表
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("depts", departments);
        //回到修改页面
        return "emp/add";
    }

    //员工修改  需要把员工ID提交
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
//        System.out.println(id);
        employeeDao.delete(id);
        System.out.println(employeeDao.getAll());
        return "redirect:/emps";  //需要加 /  否则报错无法重定向
    }
}
