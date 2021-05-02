package com.jdai.Spring5.SpringAngualrDemo.repo;

import com.jdai.Spring5.SpringAngualrDemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long employeeId);

    Employee findEmployeeById(Long employeeId);
}
