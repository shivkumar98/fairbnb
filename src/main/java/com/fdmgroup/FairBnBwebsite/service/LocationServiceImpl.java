package com.fdmgroup.FairBnBwebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.FairBnBwebsite.model.Location;
import com.fdmgroup.FairBnBwebsite.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public Location getLocationById(int locationId) {
		Location location = locationRepository.findById(locationId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid location ID:" + locationId));
		return location;
	}

	@Override
	public Location createLocation() {
		Location location = new Location();
		return location;
	}

	@Override
	public Location editLocation(Location location) {
		return locationRepository.save(location);
	}

	@Override
	public List<Location> getAllLocations() {
		return locationRepository.findAll();
	}

	@Override
	public void deleteLocation(Location location) {
		locationRepository.delete(location);

	}

	@Override
	public void deleteLocationById(int locationId) {
		Location location = locationRepository.findById(locationId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid location ID:" + locationId));
		locationRepository.delete(location);

	}

	@Override
	public Location saveLocation(Location location) {
		return locationRepository.save(location);
	}

}
