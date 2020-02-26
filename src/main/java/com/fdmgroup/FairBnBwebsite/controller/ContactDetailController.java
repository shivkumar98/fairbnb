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
import com.fdmgroup.FairBnBwebsite.service.ContactDetailService;

@Controller
public class ContactDetailController {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactDetailController.class);
	private final ContactDetailService contactDetailService;
	
	@Autowired
	public ContactDetailController(ContactDetailService contactDetailService) {
		this.contactDetailService = contactDetailService;
	}

	@GetMapping("/contactdetailindex")
	public String ContactDetailIndex(Model model) {
		logger.debug("ContactDetailIndex(): model" + model);
		model.addAttribute("contactDetailAttr", contactDetailService.getAllContactDetails());
		logger.debug("model.addAttribute(): contactDetailAttr " +
				contactDetailService.getAllContactDetails());
		return "index-contactdetails";
	}
	
	@GetMapping("/contactdetailsignup")
	public String contactDetailSignupForm(Model model) {
		logger.debug("contactDetailSignupForm(): model " + model);
		model.addAttribute("contactDetailAttr", contactDetailService.createContactDetail());
		return "add-contactdetail";
	}
	
	@PostMapping("/addcontacttype")
	public String addContactDetail(@Valid ContactDetail contactDetailAttr, BindingResult result, Model model) {
		logger.debug("addContactDetail(): contactDetailAttr " + contactDetailAttr );
		logger.debug("addContactDetail(): result " + result);
		logger.debug("addContactDetail(): model " + model);
		
		if (result.hasErrors()) {
			return "add-contactdetail";
		}

		contactDetailService.saveContactDetail(contactDetailAttr);
		logger.debug("contactDetailService.saveContactDetail(): contactDetailAttr " + contactDetailAttr);
		model.addAttribute("contactDetailAttr", contactDetailService.getAllContactDetails());
		logger.debug("model.addAttribute(): contactDetailAttr " +
				contactDetailService.getAllContactDetails());
		return "index-contactdetails";
	}
	
	@GetMapping("/editcontactdetail/{id}")
	public String contactDetailUpdateForm(@PathVariable("id") int contactId, Model model) {
		logger.debug("contactDetailUpdateForm(): contactId " + contactId);
		ContactDetail contactDetail = contactDetailService.getContactDetailById(contactId);
		logger.debug("ContactDetail: contactDetail " + 
				contactDetailService.getContactDetailById(contactId));
		model.addAttribute("contactDetailAttr", contactDetail);
		return "update-contactdetail";
	}
	
	@PostMapping("/updatecontactdetail/{id}")
	public String updateContactDetail(@PathVariable("id") int contactId,
			@Valid ContactDetail contactDetail, BindingResult result, Model model) {
		logger.debug("updateContactDetail: contactId " + contactId );
		if (result.hasErrors()) {
			return "update-contactDetail";
		}
		
		contactDetail.setContactId(contactId);
		logger.debug("contactDetail.setContactId(): " + contactDetail.getContactId());
		contactDetailService.editContactDetail(contactDetail);
		logger.debug("contactDetailService.editContactDetail(): contactDetail " +
				contactDetail);
		
		model.addAttribute("contactDetailAttr", contactDetailService.getAllContactDetails());
		logger.debug("model.addAttribute(): contactDetailAttr " + contactDetailService.getAllContactDetails());
		return "index-contactdetails";
	}
	
	@GetMapping("/deletecontactdetail/{id}")
	public String deleteContactDetail(@PathVariable("id") int contactId, Model model) {
		logger.debug("deleteContactDetail(): contactId " + contactId);
		logger.debug("deleteContactDetail(): model " + model);
		contactDetailService.deleteContactDetailById(contactId);
		model.addAttribute("contactDetailAttr", contactDetailService.getAllContactDetails());
		logger.debug("model.addAttribute(): contactDetailAttr " + 
				contactDetailService.getAllContactDetails());
		return "index-contactdetails";
	}

}
