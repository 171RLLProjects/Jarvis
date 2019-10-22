package com.mphasis.jarvis.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mphasis.jarvis.daos.FlightDao;
import com.mphasis.jarvis.entities.Flight;
import com.mphasis.jarvis.exceptions.BusinessException;

@Service
public class FlightServiceImpl implements FlightService{
	@Autowired
FlightDao flightDao;
	@Override
	public List<Flight> getAllFlight()   {
		List<Flight> flights = flightDao.getAllFlight();
		if(flights == null) {
			try {
				throw new BusinessException("No userdetails Available");
			} catch (BusinessException e) {
				System.out.println(e.getMessage());
			}
		}
		return flightDao.getAllFlight();
	}

	@Override
	public void deleteFlight(String flightId)   {
		flightDao.deleteFlight(flightId);
	}

	@Override
	public void updateFlight(Flight flight)   {
		flightDao.updateFlight(flight);
	}

	@Override
	public void addFlight(Flight flight)   {
		flightDao.addFlight(flight);
	}

	@Override
	public Flight getFlightById(String flightId)   {
		Flight flight= flightDao.getFlightById(flightId);
		if(flight==null) {
			try {
				throw new BusinessException("the requested flight is not available");
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flight;
	}

	@Override
	public List<Flight> getFlightByRoute(String routeId) {
		List<Flight> flight= flightDao.getFlightByRoute(routeId);
		if(flight==null) {
			try {
				throw new BusinessException("the requested flight is not available");
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flight;
	}

	@Override
	public List<Flight> getFilghtBySourceAndDestination(String sourceId, String destinationId) {
		List<Flight> flight= flightDao.getFilghtBySourceAndDestination(sourceId,destinationId);
		if(flight==null) {
			try {
				throw new BusinessException("the requested flight is not available");
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}
		return flight;
	
	}

	@Override
	public List<Flight> getFilghtBySourceAndDestinationAndScheduke(String sourceId, String destinationId, String sdate) {
		return flightDao.getFilghtBySourceAndDestinationAndSchedule(sourceId, destinationId,sdate);
	}

	@Override
	public void updateFlightSeatById(String flightId) {
		flightDao.updateFlightSeatById(flightId);
		
	}
	public void incrementFlightSeatById(String flightId) {
		flightDao.incrementFlightSeatById(flightId);
		
	}


}
