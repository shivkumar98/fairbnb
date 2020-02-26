package com.fdmgroup.FairBnBwebsite.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.FairBnBwebsite.model.ContactDetail;
import com.fdmgroup.FairBnBwebsite.model.Customer;
import com.fdmgroup.FairBnBwebsite.service.ContactDetailService;
import com.fdmgroup.FairBnBwebsite.service.CustomerService;

@Controller
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	private final CustomerService customerService;
	private final ContactDetailService contactDetailService;

	@Autowired
	public CustomerController(CustomerService customerService, ContactDetailService contactDetailService) {
		this.customerService = customerService;
		this.contactDetailService = contactDetailService;
	}

	@GetMapping("/customerindex")
	public String customerIndex(Model model) {
		logger.debug("customerIndex(): " + model);
		model.addAttribute("customerAttr", customerService.getAllCustomers());
		logger.debug("model.addAttribute(): " + customerService.getAllCustomers());
		return "index-customers";
	}

	@GetMapping("/customersignup")
	public String customerSignupForm(Model model) {
		logger.debug("customerSignupForm(): model " + model);
		model.addAttribute("customerAttr", customerService.createCustomer());
		logger.debug("model.addAttribute(): customerAttr " + 
				customerService.createCustomer());
		Iterable<ContactDetail> contactDetails = contactDetailService.getAllContactDetails();
		model.addAttribute("contactDetailsAttr", contactDetails);
		logger.debug("model.addAttribute(): contactDetailsAttr " + contactDetails);
		return "add-customer";
	}

	
	@PostMapping("/addcustomer")
	public String addCustomer( Customer customerAttr, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-customer";
		}
	
		customerService.saveCustomer(customerAttr);
		model.addAttribute("customerAttr", customerService.getAllCustomers());
		return "index-customers";

	}

	@GetMapping("/editcustomer/{id}")
	public String customerUpdateForm(@PathVariable("id") Integer customerId, Model model) {
		Iterable<ContactDetail> contactDetails = contactDetailService.getAllContactDetails();
		model.addAttribute("contactDetailsAttr", contactDetails);
		
		Customer customer = customerService.getCustomerById(customerId);
		model.addAttribute("customerAttr", customer);
		return "update-customer";

	}

	@PostMapping("/updatecustomer/{id}")
	public String updateCustomer(@PathVariable("id") Integer customerId, @Valid Customer customer,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "update-customer";
		}
		customer.setCustomerId(customerId);
		customerService.editCustomer(customer);
		model.addAttribute("customerAttr", customerService.getAllCustomers());
		return "index-customers";
	}


	@GetMapping("/deletecustomer/{id}")
	public String deleteCustomer(@PathVariable("id") int customerId, Model model) {
		customerService.deleteCustomerById(customerId);
		model.addAttribute("customerAttr", customerService.getAllCustomers());
		return "index-customers";
	}

}