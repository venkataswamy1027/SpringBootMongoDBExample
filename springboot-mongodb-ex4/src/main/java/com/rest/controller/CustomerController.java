package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Customer;
import com.rest.repository.CustomerRepository;

@RestController
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping("/addCustomer")
	public String saveCustomer(@RequestBody Customer customer) {
		customerRepository.save(customer);
		return "Added customer with id : " + customer.getId();
	}
	
	@GetMapping("/findAllCustomers")
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@GetMapping("/findAllByFirstName/{firstName}")
	public Customer findByFirstName(@PathVariable String firstName) {
		return customerRepository.findByFirstName(firstName);
	}

	@GetMapping("/findAllByLastName/{lastName}")
	public List<Customer> findByLastName(@PathVariable String lastName) {
		return customerRepository.findByLastName(lastName);
	}
}
