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
import com.fdmgroup.FairBnBwebsite.model.Host;
import com.fdmgroup.FairBnBwebsite.service.ContactDetailService;
import com.fdmgroup.FairBnBwebsite.service.CustomerService;
import com.fdmgroup.FairBnBwebsite.service.HostService;

@Controller
public class HostController {
	
	private static final Logger logger = LoggerFactory.getLogger(HostController.class);
	private final HostService hostService;
	private final ContactDetailService contactDetailService;
	
	@Autowired
	public HostController(HostService hostService, ContactDetailService contactDetailService) {
		this.hostService = hostService;
		this.contactDetailService = contactDetailService;
	}
	
	@GetMapping("/hostindex")
	public String HostIndex(Model model){
		logger.debug("HostIndex(): model " + model);	
		model.addAttribute("hostAttr", hostService.getAllHosts());
		logger.debug("model.addAttribute(): hostAttr " +
				hostService.getAllHosts());
		return "index-hosts";
	}
	
	@GetMapping("/hostsignup")
	public String HostSignupForm(Model model) {
		Iterable<ContactDetail> contactDetails = contactDetailService.getAllContactDetails();
		model.addAttribute("contactDetailsAttr", contactDetails);
		logger.debug("model.addAttribute(): contactDetailsAttr " + contactDetails);
		model.addAttribute("hostAttr", hostService.createHost());
		logger.debug("model.addAttribute(): hostAttr " + hostService.createHost());
		return "add-host";
	}
	
	@PostMapping("/addhost")
	public String addContactDetail(@Valid Host host, BindingResult result, Model model) {
		logger.debug("addContactDetail(): host " + host);
		logger.debug("addContactDetail(): result" + result);
		logger.debug("addContactDetail(): model " + model);
		if (result.hasErrors()) {
			return "add-host";
		}
		hostService.saveHost(host);
		ContactDetail hostDetail = contactDetailService.getContactDetailById(host.getHostDetail().getContactId());
		host.setHostDetail(hostDetail);
		logger.debug("hostService.saveHost(): host " + host);
		model.addAttribute("hostAttr", hostService.getAllHosts());
		logger.debug("model.addAttribute(): hostAttr " + 
				hostService.getAllHosts());
		hostService.saveHost(host);
		logger.debug("hostService.saveHost(): host " + host);
		model.addAttribute("contactDetailsAttr", contactDetailService.getAllContactDetails());
		logger.debug("model.addAttribute(): contactDetailsAttr " + 
				contactDetailService.getAllContactDetails());
		return "index-hosts";
	}
	
	@GetMapping("/edithost/{id}")
	public String HostUpdateForm(@PathVariable("id") int hostId, Model model) {
		logger.debug("HostUpdateForm(): hostId " + hostId); 
		logger.debug("HostUpdateForm(): model " + model); 
		Host host = hostService.getHostById(hostId);
		model.addAttribute("hostAttr", host);
		logger.debug("model.addAttribute(): hostAttr " + host);
		return "update-host";
	}
	
	@PostMapping("/updatehost/{id}")
	public String updateHost(@PathVariable("id") int hostId,
			@Valid Host host, BindingResult result, Model model) {
		logger.debug("updateHost(): hostId " + hostId);
		logger.debug("updateHost(): host" + host);
		logger.debug("updateHost(): result " + result);
		logger.debug("updateHost(): model " + model);
		if (result.hasErrors()) {
			return "update-host";
		}
		
		host.setHostId(hostId);
		logger.debug("host.setHostId(): hostId " + host.getHostId());
		hostService.editHost(host);
		logger.debug("hostService.editHost(): host " + host);
		model.addAttribute("hostAttr", hostService.getAllHosts());
		logger.debug("model.addAttribute(): hostAttr " + hostService.getAllHosts());
		return "index-hosts";
	}
	
	@GetMapping("/deletehost/{id}")
	public String deleteHost(@PathVariable("id") int hostId, Model model) {
		logger.debug("deleteHost(): hostId "+hostId);
		logger.debug("deleteHost(): model "+model);
		hostService.deleteHostById(hostId);
		model.addAttribute("hostAttr", hostService.getAllHosts());
		logger.debug("model.addAttribute(): hostAttr " + hostService.getAllHosts());
		return "index-hosts";
	}
}
