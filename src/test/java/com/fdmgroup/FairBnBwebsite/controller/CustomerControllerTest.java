package com.fdmgroup.FairBnBwebsite.controller;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fdmgroup.FairBnBwebsite.model.Customer;
import com.fdmgroup.FairBnBwebsite.service.ContactDetailService;
import com.fdmgroup.FairBnBwebsite.service.CustomerService;

public class CustomerControllerTest {
	
	private static CustomerService mockedCustomerService;
	private static ContactDetailService mockedContactDetailService;
	private static CustomerController customerController;
	private static Model mockedModel;
	private static Customer mockedCustomer;
	private static BindingResult mockedResult;

	@BeforeClass
	public static void init() {
		mockedCustomerService = mock(CustomerService.class);
		mockedContactDetailService= mock(ContactDetailService.class);
		customerController = new CustomerController(mockedCustomerService, mockedContactDetailService);
		mockedModel = mock(Model.class);
		mockedCustomer = mock(Customer.class);
		mockedResult = mock(BindingResult.class);
	}
	
	@Test
	public void test_customerIndex_returns_indexCustomers() {
		String actual = customerController.customerIndex(mockedModel);
		assertEquals("index-customers", actual);
	}
	
	@Test
	public void test_customerSignupForm_returns_addCustomer() {
		String actual = customerController.customerSignupForm(mockedModel);
		assertEquals("add-customer", actual);
	}
	
	@Test
	public void test_addCustomer_returns_addCustomer_whenResultIsInvalid() {
		when(mockedResult.hasErrors()).thenReturn(true);
		String actual = customerController.addCustomer(mockedCustomer, mockedResult, mockedModel);
		assertEquals("add-customer", actual);
	}
	
	@Test
	public void test_addCustomer_returns_indexCustomers() {
		when(mockedResult.hasErrors()).thenReturn(false);
		String actual = customerController.addCustomer(mockedCustomer, mockedResult, mockedModel);
		assertEquals("index-customers", actual);
	}
	
	@Test
	public void test_customerUpdateForm_returns_updateCustomer() {
		when(mockedCustomerService.getCustomerById(0)).thenReturn(mockedCustomer);
		String actual = customerController.customerUpdateForm(0, mockedModel);
		assertEquals("update-customer", actual);
	}
	
	@Test
	public void test_updateCustomer_returns_indexCustomers() {
		String actual = customerController.updateCustomer(0, mockedCustomer, mockedResult, mockedModel);
		assertEquals("index-customers", actual);
	}
	
	@Test
	public void test_deleteCustomer_returns_indexCustomers() {
		String actual = customerController.deleteCustomer(0, mockedModel);
		assertEquals("index-customers", actual);
	}
	

}
