package com.mphasis.jarvis.service;

import java.util.List;

import com.mphasis.jarvis.entities.Flight;
import com.mphasis.jarvis.entities.FlightClass;

public interface FlightClassService {
	public List<FlightClass> getAllFlightClass() ;
	public void deleteFlightClass(String flightClassId);
	public void updateFlightClass(FlightClass flightClass);
	public void addFlightClass(FlightClass flightClass) ;
	public FlightClass getFlightClassById(int flightClassId);
	public List<FlightClass> getFlightClassByFlightId(String flightId);
	public void updateFlightClassSeatbyName(String flightId,String flightClass);
	public void incrementFlightClassSeatbyName(String flightId, String flightClass);

}
