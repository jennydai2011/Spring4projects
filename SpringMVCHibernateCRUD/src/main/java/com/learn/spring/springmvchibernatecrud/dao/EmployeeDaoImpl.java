/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.springmvchibernatecrud.dao;

import com.learn.spring.springmvchibernatecrud.entity.Employee;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Tony
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addEmployee(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
 
    }
 
    @SuppressWarnings("unchecked")
    public List<Employee> getAllEmployees() {
 
        return sessionFactory.getCurrentSession().createQuery("from Employee")
                .list();
    }
 
    @Override
    public void deleteEmployee(Integer employeeId) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().load(
                Employee.class, employeeId);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }
 
    }
 
    public Employee getEmployee(int empid) {
        return (Employee) sessionFactory.getCurrentSession().get(
                Employee.class, empid);
    }
 
    @Override
    public Employee updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
        return employee;
    }
   
}
