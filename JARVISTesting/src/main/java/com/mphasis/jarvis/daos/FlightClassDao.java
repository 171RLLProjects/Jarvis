package com.mphasis.jarvis.daos;

import java.util.List;

import com.mphasis.jarvis.entities.Flight;
import com.mphasis.jarvis.entities.FlightClass;

public interface FlightClassDao {
	public List<FlightClass> getAllFlightClass();
	public void deleteFlightClass(String flightClassId);
	public void updateFlightClass(FlightClass flightClass);
	public void addFlightClass(FlightClass flightClass);
	public FlightClass getFlightClassById(int flightClassId);
	public List<FlightClass> getFlightClassByFlightId(String flightId);
	public void updateFlightClassSeatbyName(String flightId,String flightClass);
	void incrementFlightClassSeatbyName(String flightId, String flightClass);


}
