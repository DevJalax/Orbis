package com.scm.Supply.chain.apis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.Entity.Customer;
import com.scm.Supply.chain.apis.Service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
	private final CustomerService customerService;

	@Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable String customerId, @RequestBody Customer customer) throws Exception {
        return customerService.updateCustomer(customerId, customer);
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable String customerId) throws Exception {
        return customerService.getCustomer(customerId);
    }
}

