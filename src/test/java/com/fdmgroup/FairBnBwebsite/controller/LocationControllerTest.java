package com.fdmgroup.FairBnBwebsite.controller;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fdmgroup.FairBnBwebsite.model.Location;
import com.fdmgroup.FairBnBwebsite.service.LocationService;

public class LocationControllerTest {
	
	private static LocationController locationController;
	private static LocationService mockedLocationService;
	private static BindingResult mockedResult;
	private static Model mockedModel;
	private static Location mockedLocation;
	
	@BeforeClass
	public static void test_init() {
		mockedLocationService = mock(LocationService.class);
		locationController = new  LocationController(mockedLocationService);
		mockedResult = mock(BindingResult.class);
		mockedModel = mock(Model.class);
		mockedLocation = mock(Location.class);
	}
	
	@Test
	public void test_propertyLocationIndex_return_indexLocations() {
		String actual  = locationController.propertyLocationIndex(mockedModel);
		assertEquals("index-location", actual);
	}
	
	@Test
	public void test_propertyTypeSignupForm_return_addLocation() {
		String actual  = locationController.locationSignupForm(mockedModel);
		assertEquals("add-location", actual);
	}
	
	@Test
	public void test_addLocation_return_indexLocation() {
		String actual  = locationController.addLocation(mockedLocation, mockedResult, mockedModel);
		assertEquals("index-location", actual);
	}
	
	@Test
	public void test_updateLocation_return_indexLocation() {
		String actual  = locationController.updateLocation(0, mockedLocation, mockedResult, mockedModel);
		assertEquals("index-location", actual);
	}
	
	@Test
	public void test_deleteLocation_return_indexLocation() {
		String actual = locationController.deleteLocation(0, mockedModel);
		assertEquals("index-location", actual);
	}
	
	

}
