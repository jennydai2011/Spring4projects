package com.jdai.Spring5.SpringAngualrDemo.service;

import com.jdai.Spring5.SpringAngualrDemo.exception.UserNotFoundException;
import com.jdai.Spring5.SpringAngualrDemo.model.Employee;
import com.jdai.Spring5.SpringAngualrDemo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployess(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long employeeId) throws Throwable {
        return (Employee) employeeRepo.findEmployeeById(employeeId);
    }
    public void deleteEmployee(Long employeeId){
        employeeRepo.deleteEmployeeById(employeeId);
    }
}
