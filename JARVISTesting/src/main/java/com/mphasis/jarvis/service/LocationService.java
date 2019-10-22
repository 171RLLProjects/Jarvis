package com.mphasis.jarvis.service;

import java.util.List;

import com.mphasis.jarvis.entities.Location;

public interface LocationService {
	public void insertLocation(Location location);
	public void editLocation(Location location);
	public void removeLocation(String locationId);
	public List<Location> getAll();
	public Location getLocationByID(String locationId);
}
