package com.arbin.springbootwebrestfulcrud.entities;

public class Department {
    private Integer id;
    private String departmentName;

    public Department() {
    }

    public Department(Integer id, String string) {
        this.id = id;
        this.departmentName = string;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment() {
        return departmentName;
    }

    public void setDepartment(String department) {
        this.departmentName = department;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
