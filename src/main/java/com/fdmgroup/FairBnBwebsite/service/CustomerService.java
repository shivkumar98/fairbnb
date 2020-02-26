package com.fdmgroup.FairBnBwebsite.service;

import java.util.List;

import com.fdmgroup.FairBnBwebsite.model.Customer;

public interface CustomerService {
	Customer getCustomerById(int customerId);

	Customer createCustomer();

	Customer editCustomer(Customer customer);

	List<Customer> getAllCustomers();

	void deleteCustomer(Customer customer);

	void deleteCustomerById(int customerId);

	Customer saveCustomer(Customer customer);


}
