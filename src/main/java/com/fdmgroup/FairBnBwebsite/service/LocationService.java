package com.fdmgroup.FairBnBwebsite.service;

import java.util.List;

import com.fdmgroup.FairBnBwebsite.model.Location;


public interface LocationService {
	
	Location getLocationById(int locationId);

	Location createLocation();

	Location editLocation(Location location);

	List<Location> getAllLocations();

	void deleteLocation(Location location);

	void deleteLocationById(int locationId);

	Location saveLocation(Location location);

}
