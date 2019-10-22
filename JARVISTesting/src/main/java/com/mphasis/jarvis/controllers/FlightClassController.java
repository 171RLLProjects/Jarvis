package com.mphasis.jarvis.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.jarvis.entities.Flight;
import com.mphasis.jarvis.entities.FlightClass;
import com.mphasis.jarvis.exceptions.BusinessException;
import com.mphasis.jarvis.service.FlightClassService;

@RestController
public class FlightClassController {
	@Autowired
	FlightClassService flightClassService;
	

	@RequestMapping(value="/fs", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FlightClass>> getFlightClass(){
	    List<FlightClass> flightclass=null;
	    try {
	    	flightclass=flightClassService.getAllFlightClass();
	    } catch (Exception e) {
	         try {
	            throw new BusinessException("Invalid");
	        } catch (BusinessException e1) {
	            e1.getMessage();
	        }
	        return new ResponseEntity<List<FlightClass>>(HttpStatus.NO_CONTENT);
	    }
	return ResponseEntity.ok().body(flightclass);
	}
	
	@RequestMapping(value="/fs", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addflightClass(@RequestBody FlightClass flightClass){
		 try {
			 flightClassService.addFlightClass(flightClass);
		    }
		    catch (Exception e) {
		        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		    }
		    return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/fs",method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateFlightClass(@RequestBody FlightClass flightClass) {
	    try {
	    	flightClassService.updateFlightClass(flightClass);
	    } catch (Exception e) {
	        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	    }
	    return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}	
	
	@RequestMapping(value="/fs/{flightClassId}",method=RequestMethod.DELETE, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteFlightClass(@PathVariable("flightClassId")String flightClassId) {
	    try {
	    	flightClassService.deleteFlightClass(flightClassId);
	    } catch (Exception e) {
	        
	        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	    }
	    return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/fs/{flightClassId}",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlightClass> getFlightClassById(@PathVariable("flightClassId")int flightClassId) {
		FlightClass flightClass=null;
		try {
			flightClass=flightClassService.getFlightClassById(flightClassId);
    } catch (Exception e) {
        return new ResponseEntity<FlightClass>(HttpStatus.NO_CONTENT);
    }
    return ResponseEntity.accepted().body(flightClass);
}
	
	@RequestMapping(value="/fs1/{flightId}",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public List<FlightClass> getFlightClassByFlightId(@PathVariable("flightId")String flightId) {
		List<FlightClass> flightClasses=new ArrayList<FlightClass>();
		try {
			flightClasses=flightClassService.getFlightClassByFlightId(flightId);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flightClasses;
}
	
	
	
	@RequestMapping(value="/flightDec/{flightId}/{flightClass}",method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
	public void updateById(@PathVariable("flightId")String flightId,@PathVariable("flightClass")String flightClass) {
		
			flightClassService.updateFlightClassSeatbyName(flightId, flightClass);
	}
	
	@RequestMapping(value="/flightInc/{flightId}/{flightClass}",method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
	public void incrementById(@PathVariable("flightId")String flightId,@PathVariable("flightClass")String flightClass) {
		
			flightClassService.incrementFlightClassSeatbyName(flightId, flightClass);
	}
	
	
}
