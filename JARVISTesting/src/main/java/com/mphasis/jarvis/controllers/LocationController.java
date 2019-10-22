package com.mphasis.jarvis.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mphasis.jarvis.entities.Location;
import com.mphasis.jarvis.exceptions.BusinessException;
import com.mphasis.jarvis.service.LocationService;

@RestController
public class LocationController {
	@Autowired
	LocationService locationService;


	@RequestMapping(value="/location",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addLocation(@RequestBody Location location){
		try {
			locationService.insertLocation(location);
		}
		catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value="/location",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateLocation(@RequestBody Location location) {
		try {
			locationService.editLocation(location);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value="/location/{locationId}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteLocation(@PathVariable("locationId")String locationId) {
		try {
			locationService.removeLocation(locationId);
		} catch (Exception e) {

			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value="/location", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Location>> getLocation(){
		List<Location> location=null;
		try {
			location=locationService.getAll();
		} catch (Exception e) {
			try {
				throw new BusinessException("no location found");
			} catch (BusinessException e1) {
				e1.getMessage();
			}
			return new ResponseEntity<List<Location>>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok().body(location);
	}

	@RequestMapping(value="/location/{locationId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> getLocationById(@PathVariable("locationId")String locationId) {
		Location location=null;
		try {
			location=locationService.getLocationByID(locationId);
		} catch (Exception e) {
			return new ResponseEntity<Location>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.accepted().body(location);
	}
}
