package com.fdmgroup.FairBnBwebsite.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "location_id", unique = true, nullable = false)
	private int locationId;

	@OneToMany(mappedBy="propertyLocation")
	private List <Property> properties;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "county")
	private String county;
	
	//default constructor
	public Location () {}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}
	

}
