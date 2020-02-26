package com.fdmgroup.FairBnBwebsite.service;

import java.util.List;

import com.fdmgroup.FairBnBwebsite.model.Property;

public interface PropertyService {
	
	Property getPropertyById(int propertyId);
	
	Property createProperty();
	
	Property editProperty(Property property);
	
	List <Property> getAllPropertys();
	
	void deleteProperty(Property property);
	
	void deletePropertyById(int propertyId);
	
	Property saveProperty(Property property);

}
