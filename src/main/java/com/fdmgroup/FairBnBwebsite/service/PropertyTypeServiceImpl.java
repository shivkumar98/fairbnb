package com.fdmgroup.FairBnBwebsite.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.FairBnBwebsite.model.PropertyType;
import com.fdmgroup.FairBnBwebsite.repository.PropertyTypeRepository;

@Service
public class PropertyTypeServiceImpl implements PropertyTypeService {

	@Autowired
	private PropertyTypeRepository propertyTypeRepository;

	@Override
	public PropertyType getPropertyTypeById(int propertyTypeId) {
		PropertyType propertyType = propertyTypeRepository.findById(propertyTypeId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid property type ID:" + propertyTypeId));
		return propertyType;
	}

	@Override
	public PropertyType createPropertyType() {
		PropertyType propertyType = new PropertyType();
		return propertyType;
	}

	@Override
	public PropertyType savePropertyType(@Valid PropertyType propertyType) {
		return propertyTypeRepository.save(propertyType);
	}
	
	@Override
	public PropertyType editPropertyType(PropertyType propertyType) {
		return propertyTypeRepository.save(propertyType);
	}

	@Override
	public void deletePropertyTypeById(int propertyTypeId) {
		propertyTypeRepository.deleteById(propertyTypeId);
	}

	@Override
	public void deletePropertyType(PropertyType propertyType) {
		propertyTypeRepository.delete(propertyType);
	}

	@Override
	public List<PropertyType> getAllPropertyTypes() {
		return propertyTypeRepository.findAll();
	}


}
