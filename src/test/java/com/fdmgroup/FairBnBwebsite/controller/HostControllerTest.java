package com.fdmgroup.FairBnBwebsite.controller;

import com.fdmgroup.FairBnBwebsite.model.Host;
import com.fdmgroup.FairBnBwebsite.service.ContactDetailService;
import com.fdmgroup.FairBnBwebsite.service.HostService;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
public class HostControllerTest {
	
	private static HostService mockedHostService;
	private static ContactDetailService mockedContactDetailService;
	private static HostController hostController;
	private static Model mockedModel;
	private static Host mockedHost;
	private static BindingResult mockedResult;
	
	@BeforeClass
	public static void test_init() {
		mockedHostService = mock(HostService.class);
		mockedContactDetailService = mock(ContactDetailService.class);
		hostController = new HostController(mockedHostService, mockedContactDetailService);
		mockedModel = mock(Model.class);
		mockedHost = mock(Host.class);
		mockedResult = mock(BindingResult.class);
		
	}

	@Test
	public void test_HostIndex_returns_indexHosts() {
		String actual = hostController.HostIndex(mockedModel);
		assertEquals("index-hosts", actual);
	}
	
	@Test
	public void test_HostSignupForm_returns_indexHosts() {
		String actual = hostController.HostSignupForm(mockedModel);
		assertEquals("add-host", actual);
	}
	
	@Test
	public void test_HostUpdateForm_returns_indexHosts() {
		String actual = hostController.HostUpdateForm(0, mockedModel);
		assertEquals("update-host", actual);
	}
	
	@Test
	public void test_updateHost_returns_indexHosts() {
		String actual = hostController.updateHost(0, mockedHost, mockedResult, mockedModel);
		assertEquals("index-hosts", actual);
	}
	
	@Test
	public void test_deleteHost_returns_indexHosts() {
		String actual = hostController.deleteHost(0, mockedModel);
		assertEquals("index-hosts", actual);
	}
}
