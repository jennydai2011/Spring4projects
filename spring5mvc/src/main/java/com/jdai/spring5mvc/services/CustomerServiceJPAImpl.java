package com.jdai.spring5mvc.services;

import com.jdai.spring5mvc.domain.Customer;
import com.jdai.spring5mvc.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceJPAImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceJPAImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
