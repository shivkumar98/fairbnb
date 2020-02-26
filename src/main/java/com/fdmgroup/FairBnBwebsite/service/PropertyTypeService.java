package com.fdmgroup.FairBnBwebsite.service;

import java.util.List;

import javax.validation.Valid;

import com.fdmgroup.FairBnBwebsite.model.PropertyType;

public interface PropertyTypeService {

	PropertyType getPropertyTypeById(int propertyTypeId);

	PropertyType createPropertyType();

	PropertyType editPropertyType(PropertyType propertyType);

	List<PropertyType> getAllPropertyTypes();

	void deletePropertyType(PropertyType propertyType);

	void deletePropertyTypeById(int propertyTypeId);

	PropertyType savePropertyType(PropertyType propertyType);

}
