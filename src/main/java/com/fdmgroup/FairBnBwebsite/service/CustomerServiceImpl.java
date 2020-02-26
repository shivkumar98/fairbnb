package com.fdmgroup.FairBnBwebsite.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fdmgroup.FairBnBwebsite.model.Customer;
import com.fdmgroup.FairBnBwebsite.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer getCustomerById(int customerId) {
	Customer customer  = customerRepository.findById(customerId)
			.orElseThrow(() -> new IllegalArgumentException("Invalid Customer ID: " + customerId));
		return customer;
	}

	@Override
	public Customer createCustomer() {
		Customer customer = new Customer();
		return customer;
	}

	@Override
	public Customer editCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}

	@Override
	public void deleteCustomerById(int customerId) {
	customerRepository.deleteById(customerId);
		
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	

}
