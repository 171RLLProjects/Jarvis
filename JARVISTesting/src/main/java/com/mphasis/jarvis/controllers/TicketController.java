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

import com.mphasis.jarvis.entities.Ticket;
import com.mphasis.jarvis.exceptions.BusinessException;
import com.mphasis.jarvis.service.TicketService;


@RestController
public class TicketController {
	
	
	  @Autowired
	    TicketService ticketService;
	  
	  @RequestMapping(value="/ticket",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Void> addTicket(@RequestBody Ticket ticket){
	        try {
	        	ticketService.insertTicket(ticket);
	        }
	        catch (Exception e) {
	            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	        }
	        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	    }
	  
	
	  @RequestMapping(value="/ticket/{ticketId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Ticket> retrivePassportById(@PathVariable("ticketId") String ticketId) {

	 

	     Ticket ticket= null;
	        try {
	        ticket=ticketService.getTicketById(ticketId);
	        }catch(Exception e)
	        {
	            return new ResponseEntity<Ticket>(HttpStatus.NO_CONTENT);
	        }
	        return ResponseEntity.accepted().body(ticket);
	        
	    }
	  
	  
	  @RequestMapping(value="/cancel/{ticketId}",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)   
	  public ResponseEntity<Void> cancelTicket(@PathVariable("ticketId")String ticketId)
	  {         
		         try {
			  ticketService.cancelTicket(ticketId);
		         }
		         catch (Exception e) {
		        	 return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
				}
		         return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	  }
	  
	   
	  
}
