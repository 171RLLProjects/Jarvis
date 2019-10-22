package com.mphasis.jarvis.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mphasis.jarvis.daos.LocationDao;
import com.mphasis.jarvis.entities.Location;
import com.mphasis.jarvis.exceptions.BusinessException;
@Service
public class LocationServiceImpl implements LocationService {
	@Autowired
	LocationDao locationDao;

	public void insertLocation(Location location) {
		
			try {
				locationDao.addLocation(location);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}


	

	public void editLocation(Location location) {
	
			try {
				locationDao.updateLocation(location);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	

	public void removeLocation(String locationId) {
		if(locationId != null) {
			locationDao.deleteLocation(locationId);
		}
		else {
			try {
				throw new BusinessException("LocationId should be greater than 1");
			} catch (BusinessException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public List<Location> getAll() {
		List<Location> location = locationDao.getAll();
		if(location == null) {
			try {
				throw new BusinessException("No locations Available");
			} catch (BusinessException e) {
				System.out.println(e.getMessage());
			}
		}
		return location;
	}

	public Location getLocationByID(String locationId) {
		Location location=locationDao.getLocationByID(locationId);
		if(location == null) {
			try {
				throw new BusinessException("No location Available");
			} catch (BusinessException e) {
				System.out.println(e.getMessage());
			}
		}
		return location;
	}

}
