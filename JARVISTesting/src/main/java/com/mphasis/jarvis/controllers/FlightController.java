package com.mphasis.jarvis.controllers;

import java.util.ArrayList;
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

import com.mphasis.jarvis.entities.Flight;
import com.mphasis.jarvis.exceptions.BusinessException;
import com.mphasis.jarvis.service.FlightService;

@RestController
public class FlightController {
	@Autowired
	FlightService flightService;


	@RequestMapping(value="/flights", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Flight>> getFlights(){
		List<Flight> flights=null;
		try {
			flights=flightService.getAllFlight();
		} catch (Exception e) {
			try {
				throw new BusinessException("Invalid");
			} catch (BusinessException e1) {
				e1.getMessage();
			}
			return new ResponseEntity<List<Flight>>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok().body(flights);
	}

	@RequestMapping(value="/flights",method=RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addflights(@RequestBody Flight flight){
		try {
			flightService.addFlight(flight);
		}
		catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value="/flights",method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateFlight(@RequestBody Flight flight) {
		try {
			flightService.updateFlight(flight);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}	

	@RequestMapping(value="/flights/{flightId}",method=RequestMethod.DELETE, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteFlight(@PathVariable("flightId")String flightId) {
		try {
			flightService.deleteFlight(flightId);
		} catch (Exception e) {

			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value="/flights/{flightId}",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Flight> getFlightById(@PathVariable("flightId")String flightId) {
		Flight flight=null;
		try {
			flight=flightService.getFlightById(flightId);
		} catch (Exception e) {
			return new ResponseEntity<Flight>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.accepted().body(flight);
	}

	@RequestMapping(value="/flights1/{routeId}",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> getFlightByRoute(@PathVariable("routeId")String routeId) {
		List<Flight> flights=new ArrayList<Flight>();
		try {
			flights=flightService.getFlightByRoute(routeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flights;
	}
	
	@RequestMapping(value="/flights/{sourceId}/{destinationId}",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> getFilghtBySourceAndDestination(@PathVariable("sourceId")String sourceId, @PathVariable("destinationId")String destinationId) {
		List<Flight> flights=new ArrayList<Flight>();
		try {
			flights=flightService.getFilghtBySourceAndDestination(sourceId,destinationId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flights;
	}

	@RequestMapping(value="/flights/{sourceId}/{destinationId}/{sdate}",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> getFilghtBySourceAndDestinationAndSchedule(@PathVariable("sourceId")String sourceId, @PathVariable("destinationId")String destinationId,
			@PathVariable("sdate")String sdate) {
		List<Flight> flights=new ArrayList<Flight>();
		try {
			flights=flightService.getFilghtBySourceAndDestinationAndScheduke(sourceId,destinationId,sdate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flights;
	}




	@RequestMapping(value="/flightseat/{flightId}",method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
	public void updateById(@PathVariable("flightId")String flightId) {

		flightService.updateFlightSeatById(flightId);
	}

	@RequestMapping(value="/flightseat1/{flightId}",method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
	public void incrementById(@PathVariable("flightId")String flightId) {

		flightService.incrementFlightSeatById(flightId);
	}




}
