package com.mphasis.jarvis.service;

import java.util.List;

import com.mphasis.jarvis.entities.Flight;
import com.mphasis.jarvis.exceptions.BusinessException;


public interface FlightService {
	public List<Flight> getAllFlight()   ;
	public void deleteFlight(String flightId)   ;
	public void updateFlight(Flight flight)  ;
	public void addFlight(Flight flight)  ;
	public Flight getFlightById(String flightId)  ;
	public List<Flight> getFlightByRoute(String routeId);
	public List<Flight> getFilghtBySourceAndDestination(String sourceId,String destinationId);
	public List<Flight> getFilghtBySourceAndDestinationAndScheduke(String sourceId, String destinationId, String sdate);
	public void updateFlightSeatById(String flightId);
	public void incrementFlightSeatById(String flightId);
}
