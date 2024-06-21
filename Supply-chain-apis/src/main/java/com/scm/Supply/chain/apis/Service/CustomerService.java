package com.scm.Supply.chain.apis.Service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Customer;
import com.scm.Supply.chain.apis.Repo.CustomerRepository;

@Service
public class CustomerService {
    
	private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(String customerId, Customer updatedCustomer) throws Exception {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new Exception("Customer not found"));
        customer.setFirstName(updatedCustomer.getFirstName());
        customer.setLastName(updatedCustomer.getLastName());
        customer.setEmail(updatedCustomer.getEmail());
        customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
        customer.setAddress(updatedCustomer.getAddress());
        customer.setUpdatedAt(Instant.now());
        return customerRepository.save(customer);
    }

    public Customer getCustomer(String customerId) throws Exception {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new Exception("Customer not found"));
    }
}

