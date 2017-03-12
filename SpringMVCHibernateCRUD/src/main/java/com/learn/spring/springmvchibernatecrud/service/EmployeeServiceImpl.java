/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.springmvchibernatecrud.service;

import com.learn.spring.springmvchibernatecrud.dao.EmployeeDAO;
import com.learn.spring.springmvchibernatecrud.entity.Employee;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Tony
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
 
    @Autowired
    private EmployeeDAO employeeDAO;
 
    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }
 
    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
 
    @Override
    @Transactional
    public void deleteEmployee(Integer employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }
 
    public Employee getEmployee(int empid) {
        return employeeDAO.getEmployee(empid);
    }
 
    public Employee updateEmployee(Employee employee) {
        // TODO Auto-generated method stub
        return employeeDAO.updateEmployee(employee);
    }
 
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    
 
}
