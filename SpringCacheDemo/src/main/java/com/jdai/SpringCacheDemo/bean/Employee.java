package com.jdai.SpringCacheDemo.bean;

import java.io.Serializable;

public class Employee implements Serializable {
    private Integer id;
    private String name;
    private String email;
    private Integer gender;
    private Integer deptId;

    public Employee() {
    }

    public Employee(Integer id, String name, String email, Integer gender, Integer deptId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.deptId = deptId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}