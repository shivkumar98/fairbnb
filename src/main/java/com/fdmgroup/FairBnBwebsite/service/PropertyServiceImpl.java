package com.fdmgroup.FairBnBwebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.FairBnBwebsite.model.Property;
import com.fdmgroup.FairBnBwebsite.repository.PropertyRepository;

@Service
public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
	private PropertyRepository propertyRepository;

	@Override
	public Property getPropertyById(int propertyId) {
		Property property = propertyRepository.findById(propertyId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid property ID:" + propertyId));
		return property;
	}

	@Override
	public Property createProperty() {
		Property property = new Property();
		return property;
	}

	@Override
	public Property editProperty(Property property) {
		return propertyRepository.save(property);
	}

	@Override
	public List<Property> getAllPropertys() {
		return propertyRepository.findAll();
	}

	@Override
	public void deleteProperty(Property property) {
		propertyRepository.delete(property);
		
	}

	@Override
	public void deletePropertyById(int propertyId) {
		Property property = propertyRepository.findById(propertyId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid property ID:" + propertyId));
		propertyRepository.delete(property);
		
	}

	@Override
	public Property saveProperty(Property property) {
		return propertyRepository.save(property);
	}

}
