package com.fdmgroup.FairBnBwebsite.service;

import java.util.List;

import com.fdmgroup.FairBnBwebsite.model.ContactDetail;

public interface ContactDetailService {
	
	ContactDetail getContactDetailById(int contactDetailId);
	
	ContactDetail createContactDetail();
	
	ContactDetail editContactDetail( ContactDetail contactDetail );

	List<ContactDetail> getAllContactDetails();
	
	void deleteContactDetail(ContactDetail contactDetail);
	
	void deleteContactDetailById(int contactDetailId);
	
	ContactDetail saveContactDetail(ContactDetail contactDetail);
	
}
