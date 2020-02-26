package com.fdmgroup.FairBnBwebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.FairBnBwebsite.model.ContactDetail;
import com.fdmgroup.FairBnBwebsite.repository.ContactDetailRepository;

@Service
public class ContactDetailServiceImpl implements ContactDetailService{
	
	@Autowired
	private ContactDetailRepository contactDetailRepository;

	@Override
	public ContactDetail getContactDetailById(int contactDetailId) {
		ContactDetail contactDetail = contactDetailRepository.findById(contactDetailId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Contact Detail ID: " + contactDetailId));
		return contactDetail;
	}

	@Override
	public ContactDetail createContactDetail() {
		ContactDetail contactDetail = new ContactDetail(); 
		return contactDetail;
	}

	@Override
	public ContactDetail editContactDetail(ContactDetail contactDetail) {
		return contactDetailRepository.save(contactDetail);
	}

	@Override
	public List<ContactDetail> getAllContactDetails() {
		return contactDetailRepository.findAll();
	}

	@Override
	public void deleteContactDetail(ContactDetail contactDetail) {
		contactDetailRepository.delete(contactDetail);
	}

	@Override
	public void deleteContactDetailById(int contactDetailId) {
		contactDetailRepository.deleteById(contactDetailId);
		
	}

	@Override
	public ContactDetail saveContactDetail(ContactDetail contactDetail) {
		return contactDetailRepository.save(contactDetail);
	}

}
