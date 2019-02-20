package com.jdai.spring5mvc.bootstrap;

import com.jdai.spring5mvc.domain.Customer;
import com.jdai.spring5mvc.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private CustomerRepository customerRepository;

    public BootStrapData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading customer data");

        Customer c1 = new Customer();
        c1.setFirstname("Peppa");
        c1.setLastname("Pig");
        customerRepository.save(c1);

        Customer c2 = new Customer();
        c2.setFirstname("George");
        c2.setLastname("Pig");
        customerRepository.save(c2);

        Customer c3 = new Customer();
        c3.setFirstname("Mother");
        c3.setLastname("Pig");
        customerRepository.save(c3);

        System.out.println("Customers saved: " + customerRepository.count());

    }
}
