package com.fdmgroup.FairBnBwebsite.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="contact_details")
public class ContactDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contact_id", unique = true, nullable = false)
	private int contactId;
	
	@OneToMany(mappedBy="customerDetail", cascade=CascadeType.ALL)
	private List<Customer> customers;

	@OneToMany(mappedBy="hostDetail", cascade=CascadeType.ALL)
	private List<Host> host;

	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="email_address")
	private String emailAddress;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	
	public ContactDetail() {
	}


	public int getContactId() {
		return contactId;
	}


	public void setContactId(int contactId) {
		this.contactId = contactId;
	}


	


	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return "ContactDetail [contactId=" + contactId + ", phoneNumber=" + phoneNumber + ", emailAddress="
				+ emailAddress + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}



	
	

	

}
