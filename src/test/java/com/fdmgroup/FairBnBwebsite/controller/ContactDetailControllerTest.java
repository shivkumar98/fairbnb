package com.fdmgroup.FairBnBwebsite.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.fdmgroup.FairBnBwebsite.model.ContactDetail;
import com.fdmgroup.FairBnBwebsite.service.ContactDetailService;

public class ContactDetailControllerTest {
	private static Model mockedModel;
	private static ContactDetailService mockedContactDetailService;
	private static ContactDetailController contactDetailController;
	private static ContactDetail contactDetail;
	private static BindingResult mockedResult;

	@BeforeClass
	public static void init() {
		mockedModel = mock(Model.class);
		mockedContactDetailService = mock(ContactDetailService.class);
		contactDetailController = new ContactDetailController(mockedContactDetailService);
		contactDetail = mock(ContactDetail.class);
		mockedResult = mock(BindingResult.class);
	}

	@Test
	public void test_ContactDetailIndex_returns_indexContactDetails() {
		String actual = contactDetailController.ContactDetailIndex(mockedModel);
		assertEquals("index-contactdetails", actual);
	}

	@Test
	public void test_contactDetailSignupForm_returns_addContactDetail() {
		String actual = contactDetailController.contactDetailSignupForm(mockedModel);
		assertEquals("add-contactdetail", actual);
	}

	@Test
	public void test_addContactDetail_returns_addContactDetail_When_ResultHasErrors() {
		String actual = contactDetailController.addContactDetail(contactDetail, mockedResult, mockedModel);
		assertEquals("index-contactdetails", actual);
	}

	@Test
	public void test_contactDetailUpdateForm_returns_updateContactDetail() {
		String actual = contactDetailController.contactDetailUpdateForm(0, mockedModel);
		assertEquals("update-contactdetail", actual);
	}
	
	@Test
	public void test_updateContactDetail_returns_updateContactDetail() {
		String actual = contactDetailController.updateContactDetail(0, contactDetail, mockedResult, mockedModel);
		assertEquals("index-contactdetails", actual);
	}
	
	@Test
	public void test_deleteContactDetail_indexContactDetails_return_indexContactDetails() {
		String actual = contactDetailController.deleteContactDetail(0, mockedModel);
		assertEquals("index-contactdetails", actual);
	}

}
