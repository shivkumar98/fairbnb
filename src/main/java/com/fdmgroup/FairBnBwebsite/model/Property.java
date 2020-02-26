package com.fdmgroup.FairBnBwebsite.model;

import java.util.List;
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
@Table(name = "properties")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name = "property_id", unique = true, nullable = false)
	private int propertyId;
	
	@OneToMany(mappedBy="reservationProperty")
	private List <Reservation> reservation;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "host_id") //hostId
	private Host propertyHost;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "location_id") //locationId
	private Location propertyLocation;	
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "property_type_id")
	private PropertyType propertyType;
	
	@Column(name = "nightly_rate")
	private int nightlyRate;

	//default constructor
	public Property(){}
	
	public Property(int propertyId, List<Reservation> reservation, Host propertyHost, Location propertyLocation,
			PropertyType propertyType, int nightlyRate) {
		super();
		this.propertyId = propertyId;
		this.reservation = reservation;
		this.propertyHost = propertyHost;
		this.propertyLocation = propertyLocation;
		this.propertyType = propertyType;
		this.nightlyRate = nightlyRate;
	}



	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public Host getPropertyHost() {
		return propertyHost;
	}

	public void setPropertyHost(Host propertyHost) {
		this.propertyHost = propertyHost;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	
	public int getNightlyRate() {
		return nightlyRate;
	}

	public void setNightlyRate(int nightlyRate) {
		this.nightlyRate = nightlyRate;
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	public Location getPropertyLocation() {
		return propertyLocation;
	}

	public void setPropertyLocation(Location propertyLocation) {
		this.propertyLocation = propertyLocation;
	}

	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", propertyHost=" + propertyHost + ", nightlyRate=" + nightlyRate
				+ "]";
	}

	

	
}
