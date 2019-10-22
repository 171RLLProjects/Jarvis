package com.mphasis.jarvis.daos;

import java.util.List;
import com.mphasis.jarvis.entities.Flight;

public interface FlightDao {
	public List<Flight> getAllFlight();
	public void deleteFlight(String flightId);
	public void updateFlight(Flight flight);
	public void addFlight(Flight flight);
	public Flight getFlightById(String flightId);
	public List<Flight> getFlightByRoute(String routeId);
	public List<Flight> getFilghtBySourceAndDestination(String sourceId,String destinationId);
	public List<Flight> getFilghtBySourceAndDestinationAndSchedule(String sourceId, String destinationId, String sdate);
	public void updateFlightSeatById(String flightId);
	void incrementFlightSeatById(String flightId);


}
