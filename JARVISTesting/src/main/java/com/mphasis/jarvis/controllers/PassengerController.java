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
import com.mphasis.jarvis.entities.Passenger;
import com.mphasis.jarvis.exceptions.BusinessException;
import com.mphasis.jarvis.service.PassengerService;

@RestController
public class PassengerController {
	@Autowired
    PassengerService passengerService;
  
  
 
    @RequestMapping(value="/insertpass",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addPassenger(@RequestBody Passenger passenger){
       
    	try {
        passengerService.registerPassenger(passenger);	
        }
        catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
	 
	  @RequestMapping(value="/passenger", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity <List<Passenger>> getPassenger(){
	      List<Passenger> passengers=null;
	      try {
	    	  passengers=passengerService.getAllPassenger();
	      } catch (Exception e) {
	           try {
	              throw new BusinessException("Invalid");
	          } catch (BusinessException e1) {
	              e1.getMessage();
	          }
	          return new ResponseEntity<List<Passenger>>(HttpStatus.NO_CONTENT);
	      }
	  return ResponseEntity.ok().body(passengers);
	  }	 
	  
	  
	  
	  @RequestMapping(value="/updatepass/{passengerId}",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)   
	  public ResponseEntity<Void> cancelPassenger(@PathVariable("passengerId")String passengerId)
	  {        
		  		try {
		         passengerService.cancelPassenger(passengerId);}
		  		catch(Exception e) {
		  			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		  		}
		  		 return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	  }
	  @RequestMapping(value="/pass/{passengerId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)   
	  public ResponseEntity<Passenger> getpassengerById(@PathVariable("passengerId")String passengerId) {
		  
		 Passenger passenger= null;
		 try {
			 
				 	passenger=passengerService.getPassengerById(passengerId);
				 }catch (Exception e) {
			            return new ResponseEntity<Passenger>(HttpStatus.NO_CONTENT);
			        }
			        return ResponseEntity.accepted().body(passenger);
			    }
}
