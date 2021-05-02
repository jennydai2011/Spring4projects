package com.jdai.Spring5.SpringAngualrDemo.controller;

import com.jdai.Spring5.SpringAngualrDemo.model.Employee;
import com.jdai.Spring5.SpringAngualrDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employeeList = employeeService.findAllEmployess();
        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Long id) throws Throwable {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws Throwable {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update") //update use PUT method
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) throws Throwable {
        Employee newEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}") //delete use DELETE method
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id) throws Throwable {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
