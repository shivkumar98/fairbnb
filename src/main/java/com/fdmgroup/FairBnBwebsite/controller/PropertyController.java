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

import com.fdmgroup.FairBnBwebsite.model.Host;
import com.fdmgroup.FairBnBwebsite.model.Location;
import com.fdmgroup.FairBnBwebsite.model.Property;
import com.fdmgroup.FairBnBwebsite.model.PropertyType;
import com.fdmgroup.FairBnBwebsite.service.HostService;
import com.fdmgroup.FairBnBwebsite.service.LocationService;
import com.fdmgroup.FairBnBwebsite.service.PropertyService;
import com.fdmgroup.FairBnBwebsite.service.PropertyTypeService;

@Controller
public class PropertyController {
	
	private static final Logger logger = LoggerFactory.getLogger(PropertyController.class);
	private final PropertyService propertyService;
	private final HostService hostService;
	private final LocationService locationService;
	private final PropertyTypeService propertyTypeService;
	
	@Autowired
	public PropertyController(PropertyService propertyService, HostService hostService,
			LocationService locationService, PropertyTypeService propertyTypeService) {
		this.propertyService = propertyService;	
		this.hostService = hostService;
		this.locationService = locationService;
		this.propertyTypeService = propertyTypeService;
	}
	
	@GetMapping("/propertyindex")
	public String propertyIndex(Model model) {
		model.addAttribute("propertyAttr", propertyService.getAllPropertys());
		logger.debug("model.addAttribute(): propertyAttr " + 
				 propertyService.getAllPropertys());
		return "index-property";
	}

	@GetMapping("/propertysignup")
	public String propertySignupForm(Model model) {
		Iterable<PropertyType> propertyTypes = propertyTypeService.getAllPropertyTypes();
		model.addAttribute("propertyTypes", propertyTypes);
		logger.debug("model.addAttribute(): propertyTypes " + propertyTypes);
		Iterable<Location> locations = locationService.getAllLocations();
		model.addAttribute("locations", locations);
		logger.debug("model.addAttribute(): locations "+locations);
		Iterable<Host> hosts = hostService.getAllHosts();
		model.addAttribute("hosts", hosts);	
		logger.debug("model.addAttribute(): hosts " + hosts);
		model.addAttribute("propertyAttr", propertyService.createProperty());
		logger.debug("model.addAttribute(): propertyAttr " +
				propertyService.createProperty());
		return "add-property";
	}

	@PostMapping("/addproperty")
	public String addProperty(@Valid Property propertyAttr, BindingResult result, Model model) {
		logger.debug("addProperty(): property " + propertyAttr);
		logger.debug("addProperty(): result " + result);
		logger.debug("addProperty(): model " + model);
		if (result.hasErrors()) {
			return "add-property";
		}

		propertyService.saveProperty(propertyAttr);
		model.addAttribute("propertyAttr", propertyService.getAllPropertys());
		logger.debug("model.addAttribute(): propertyAttr " +
				propertyService.getAllPropertys());
		return "index-property";
	}

	@GetMapping("/editproperty/{id}")
	public String propertyUpdateForm(@PathVariable("id") int propertyId, Model model) {
		logger.debug( "propertyUpdateForm(): propertyId " + propertyId);
		logger.debug( "propertyUpdateForm(): model " + model);
		Property property = propertyService.getPropertyById(propertyId);
		model.addAttribute("propertyAttr", property);
		logger.debug("model.addAttribute(): propertyAttr " + property);
		return "update-property";
	}

	@PostMapping("/updateproperty/{id}")
	public String updateProperty(@PathVariable("id") int propertyId, @Valid Property property,
			BindingResult result, Model model) {
		logger.debug("updateProperty(): propertyId " + propertyId);
		logger.debug("updateProperty(): property " + property);
		if (result.hasErrors()) {
			return "update-property";
		}

		property.setPropertyId(propertyId);
		propertyService.editProperty(property);
		model.addAttribute("propertyAttr", propertyService.getAllPropertys());
		logger.debug("model.addAttribute(): propertyAttr " +
				propertyService.getAllPropertys());
		return "index-property";
	}

	@GetMapping("/deleteproperty/{id}")
	public String deleteProperty(@PathVariable("id") int propertyId, Model model) {
		logger.debug("deleteProperty(): propertyId " + propertyId);
		logger.debug("deleteProperty(): model " + model);
		propertyService.deletePropertyById(propertyId);
		model.addAttribute("propertyAttr", propertyService.getAllPropertys());
		logger.debug("model.addAttribute(): propertyAttr " +
				propertyService.getAllPropertys());
		return "index-property";
	}
	
	

}
