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
@Table(name = "hosts")
public class Host {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "host_id", unique = true, nullable = false)
	private int hostId;
	
	@OneToMany(mappedBy="propertyHost")
	private List <Property> properties;
	

	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	@JoinColumn(name="contact_id") //contactId
	private ContactDetail hostDetail;
	
	//default constructor
	public Host(){}

	public int getHostId() {
		return hostId;
	}

	public void setHostId(int hostId) {
		this.hostId = hostId;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public ContactDetail getHostDetail() {
		return hostDetail;
	}

	public void setHostDetail(ContactDetail hostDetail) {
		this.hostDetail = hostDetail;
	}

	@Override
	public String toString() {
		return "Host [hostId=" + hostId + ", hostDetail=" + hostDetail + "]";
	}

	
	

	
}
