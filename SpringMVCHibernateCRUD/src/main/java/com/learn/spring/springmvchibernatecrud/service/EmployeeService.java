/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.springmvchibernatecrud.service;

import com.learn.spring.springmvchibernatecrud.entity.Employee;
import java.util.List;

/**
 *
 * @author Tony
 */
public interface EmployeeService {
    public void addEmployee(Employee employee);
 
    public List<Employee> getAllEmployees();
 
    public void deleteEmployee(Integer employeeId);
 
    public Employee getEmployee(int employeeid);
 
    public Employee updateEmployee(Employee employee);
}
