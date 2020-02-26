package com.fdmgroup.FairBnBwebsite.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.FairBnBwebsite.model.Location;
import com.fdmgroup.FairBnBwebsite.service.LocationService;

@Controller
public class LocationController {
	
	private final LocationService locationService;
	
	@Autowired
	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}
	
	@GetMapping("/locationindex")
	public String propertyLocationIndex(Model model) {
		model.addAttribute("locationAttr", locationService.getAllLocations());
		return "index-location";
	}

	@GetMapping("/locationsignup")
	public String locationSignupForm(Model model) {
		model.addAttribute("locationAttr", locationService.createLocation());
		return "add-location";
	}

	@PostMapping("/addlocation")
	public String addLocation(@Valid Location locationAttr, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-location";
		}

		locationService.saveLocation(locationAttr);
		model.addAttribute("locationAttr", locationService.getAllLocations());
		return "index-location";
	}

	@GetMapping("/editlocation/{id}")
	public String propertyLocation(@PathVariable("id") Integer locationId, Model model) {
		Location location = locationService.getLocationById(locationId);
		model.addAttribute("locationAttr", location);
		return "update-location";

	}

	@PostMapping("/updatelocation/{id}")
	public String updateLocation(@PathVariable("id") Integer locationId, @Valid Location location,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "update-location";
		}
		location.setLocationId(locationId);
		locationService.editLocation(location);
		model.addAttribute("locationAttr", locationService.getAllLocations());
		return "index-location";
	}

	@GetMapping("/deletelocation/{id}")
	public String deleteLocation(@PathVariable("id") Integer locationId, Model model) {
		locationService.deleteLocationById(locationId);
		model.addAttribute("locationAttr", locationService.getAllLocations());
		return "index-location";
	}

}
