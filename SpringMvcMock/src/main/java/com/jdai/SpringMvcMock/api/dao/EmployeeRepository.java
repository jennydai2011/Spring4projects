package com.jdai.SpringMvcMock.api.dao;

import com.jdai.SpringMvcMock.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
