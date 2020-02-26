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
import com.fdmgroup.FairBnBwebsite.model.Customer;
import com.fdmgroup.FairBnBwebsite.model.Property;
import com.fdmgroup.FairBnBwebsite.model.Reservation;
import com.fdmgroup.FairBnBwebsite.service.ContactDetailService;
import com.fdmgroup.FairBnBwebsite.service.CustomerService;
import com.fdmgroup.FairBnBwebsite.service.PropertyService;
import com.fdmgroup.FairBnBwebsite.service.ReservationService;

@Controller
public class ReservationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	private final ReservationService reservationService;
	private final CustomerService customerService;
	private final PropertyService propertyService;
	private final ContactDetailService contactDetailService;
	
	@Autowired
	public ReservationController(ReservationService reservationService, CustomerService customerService, 
			PropertyService propertyService, ContactDetailService contactDetailService) {
		this.reservationService = reservationService;
		this.customerService = customerService;
		this.propertyService = propertyService;
		this.contactDetailService = contactDetailService;
	}
	
	@GetMapping("/reservationindex")
	public String reservationIndex(Model model) {
		model.addAttribute("reservationAttr", reservationService.getAllReservations());
		logger.debug("model.addAttribute(): reservationAttr " 
				+ reservationService.getAllReservations());
		return "index-reservations";
	}
	
	@GetMapping("/reservationsignup")
	public String reservationSignupForm(Model model) {
		Iterable<Customer> customers = customerService.getAllCustomers();
		model.addAttribute("customersAttr", customers);
		logger.debug("model.addAttribute(): customersAttr " 
				+ customers);
		
		Iterable<Property> properties = propertyService.getAllPropertys();
		model.addAttribute("propetiesAttr", properties);
		logger.debug("model.addAttribute(): propertiesAttr " 
				+ properties);
		
		model.addAttribute("reservationAttr", reservationService.createReservation());
		logger.debug("model.addAttribute(): reservationAttr " 
				+ reservationService.createReservation());
		model.addAttribute("propertiesAttr", propertyService.getAllPropertys());
		logger.debug("model.addAttribute(): propertiesAttr " 
				+ propertyService.getAllPropertys());
		return "add-reservation";
	}
	
	
	@PostMapping("addreservation")
	public String addReservation(@Valid Reservation reservationAttr, BindingResult result, Model model) {
		logger.debug("addReservation(): reservationAttr "
				+ reservationAttr);
		logger.debug("addReservation(): result "
				+ result);
		logger.debug("addReservation(): model "
				+ model);
		if (result.hasErrors()) {
			return "add-reservation";
		}
		reservationService.saveReservation(reservationAttr);
		contactDetailService.getAllContactDetails();
		model.addAttribute("reservationAttr", reservationService.getAllReservations());
		logger.debug("model.addAttribute(): reservationAttr "
				+ reservationService.getAllReservations());
		return "index-reservations";
	}
	
	@GetMapping("/editreservation/{id}")
	public String reservationUpdateForm(@PathVariable("id") int reservationId, Model model) {
		Reservation reservation = reservationService.getReservationById(reservationId);
		Iterable<Customer> customers = customerService.getAllCustomers();
		model.addAttribute("customersAttr", customers);
		model.addAttribute("reservationAttr", reservation);
		model.addAttribute("propertiesAttr", propertyService.getAllPropertys());
		return "update-reservation";

	}

	@PostMapping("/updatereservation/{id}")
	public String updateReservation(@PathVariable("id") int reservationId,
			@Valid Reservation reservation, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "update-reservation";
		}
		reservation.setReservationId(reservationId);
		reservationService.editReservation(reservation);
		model.addAttribute("reservationAttr", reservationService.getAllReservations());
		return "index-reservations";
	}
	
	
	@GetMapping("/deletereservation/{id}")
	public String deleteReservation(@PathVariable("id") int reservationId, Model model) {
		logger.debug("deleteReservation(): reservationId " + reservationId);
		logger.debug("deleteReservation(): model " + model);
		reservationService.deleteRedervationById(reservationId);
		model.addAttribute("reservationAttr", reservationService.getAllReservations());
		logger.debug("model.addAttribute(): reservationAttr " 
				+ reservationService.getAllReservations());
		return "index-reservations";
	}

}
