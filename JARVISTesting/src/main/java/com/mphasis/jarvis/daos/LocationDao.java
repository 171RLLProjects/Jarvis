package com.mphasis.jarvis.daos;

import java.util.List;

import com.mphasis.jarvis.entities.Location;

public interface LocationDao {
	public void addLocation(Location location);
	public void updateLocation(Location location);
	public void deleteLocation(String locationId);
	public List<Location> getAll();
	public Location getLocationByID(String locationId);
}
