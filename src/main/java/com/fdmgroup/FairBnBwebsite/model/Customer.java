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
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id", unique = true, nullable = false)
	private int customerId;
	@OneToMany(mappedBy="customerReservation")
	private List <Reservation> reservations;
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="contact_id") //contact id
	private ContactDetail customerDetail;

	//default constructor
	public Customer() {
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public ContactDetail getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(ContactDetail customerDetail) {
		this.customerDetail = customerDetail;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerDetail=" + customerDetail + "]";
	}

	
	
}
