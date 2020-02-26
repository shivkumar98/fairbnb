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

import com.fdmgroup.FairBnBwebsite.model.PropertyType;
import com.fdmgroup.FairBnBwebsite.service.PropertyTypeService;


@Controller
public class PropertyTypeController {

	private static final Logger logger = LoggerFactory.getLogger(PropertyTypeController.class);
	private final PropertyTypeService propertyTypeService;

	@Autowired
	public PropertyTypeController(PropertyTypeService propertyTypeService) {
		this.propertyTypeService = propertyTypeService;
	}

	@GetMapping("/propertytypeindex")
	public String propertyTypeIndex(Model model) {
		logger.debug("propertyTypeIndex(): model " + model);
		model.addAttribute("propertyTypeAttr", propertyTypeService.getAllPropertyTypes());
		logger.debug("model.addAttribute(): propertyTypeAttr" +
				propertyTypeService.getAllPropertyTypes());
		return "index-propertytypes";
	}

	@GetMapping("/propertytypesignup")
	public String propertyTypeSignupForm(Model model) {
		logger.debug("propertyTypeSignupForm(): model "+model);
		model.addAttribute("propertyTypeAttr", propertyTypeService.createPropertyType());
		logger.debug("model.addAttribute(): propertyAttr "
				+ propertyTypeService.createPropertyType());
		return "add-propertytype";
	}

	@PostMapping("/addpropertytype")
	public String addPropertyType(@Valid PropertyType propertyTypeAttr, BindingResult result, Model model) {
		logger.debug("addPropertyType(): propertyTypeAttr " + propertyTypeAttr);
		if (result.hasErrors()) {
			return "add-propertytype";
		}

		propertyTypeService.savePropertyType(propertyTypeAttr);
		model.addAttribute("propertyTypeAttr", propertyTypeService.getAllPropertyTypes());
		logger.debug("model.addAttribute(): propertyTypeAttr " +
				propertyTypeService.getAllPropertyTypes());
		return "index-propertytypes";
	}

	@GetMapping("/editpropertytype/{id}")
	public String propertyTypeUpdateForm(@PathVariable("id") Integer propertyTypeId, Model model) {
		logger.debug("propertyTypeUpdateForm(): propertyTypeId " + propertyTypeId);
		PropertyType propertyType = propertyTypeService.getPropertyTypeById(propertyTypeId);
		model.addAttribute("propertyTypeAttr", propertyType);
		logger.debug("model.addAttribute(): propertyTypeAttr "+propertyType);
		return "update-propertytype";

	}

	@PostMapping("/updatepropertytype/{id}")
	public String updatePropertyType(@PathVariable("id") Integer propertyTypeId, @Valid PropertyType propertyType,
			BindingResult result, Model model) {
		logger.debug("updatePropertyType(): propertyTypeId " +propertyTypeId );
		if (result.hasErrors()) {
			return "update-propertytype";
		}
		propertyType.setPropertyTypeId(propertyTypeId);
		propertyTypeService.editPropertyType(propertyType);
		model.addAttribute("propertyTypeAttr", propertyTypeService.getAllPropertyTypes());
		logger.debug("model.addAttribute(): propertyTypeAttr " + propertyTypeService.getAllPropertyTypes());
		return "index-propertytypes";
	}

	@GetMapping("/deletepropertytype/{id}")
	public String deletePropertyType(@PathVariable("id") Integer propertyTypeId, Model model) {
		logger.debug("deletePropertyType(): propertyTypeId " +propertyTypeId);
		logger.debug("deletePropertyType(): model " +model);
		propertyTypeService.deletePropertyTypeById(propertyTypeId);
		model.addAttribute("propertyTypeAttr", propertyTypeService.getAllPropertyTypes());
		logger.debug("model.addAttribute(): propertyTypeAttr " + 
				propertyTypeService.getAllPropertyTypes());
		return "index-propertytypes";
	}

}