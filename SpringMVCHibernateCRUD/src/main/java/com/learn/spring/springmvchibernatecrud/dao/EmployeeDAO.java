/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.springmvchibernatecrud.dao;

import java.util.List;

import com.learn.spring.springmvchibernatecrud.entity.Employee;
/**
 *
 * @author Tony
 */
public interface EmployeeDAO {
    
    public void addEmployee (Employee employee);
    
    public List<Employee> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
 
    public Employee updateEmployee(Employee employee);
 
    public Employee getEmployee(int employeeid);
    
}
