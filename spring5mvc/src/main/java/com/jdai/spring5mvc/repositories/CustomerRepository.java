package com.jdai.spring5mvc.repositories;

import com.jdai.spring5mvc.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
