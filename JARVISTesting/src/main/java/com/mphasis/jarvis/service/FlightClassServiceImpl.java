package com.mphasis.jarvis.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mphasis.jarvis.daos.FlightClassDao;
import com.mphasis.jarvis.entities.Flight;
import com.mphasis.jarvis.entities.FlightClass;
import com.mphasis.jarvis.exceptions.BusinessException;

@Service
public class FlightClassServiceImpl implements FlightClassService{
	@Autowired
	FlightClassDao flightClassDao;

	@Override
	public List<FlightClass> getAllFlightClass()  {
		List<FlightClass> flightClasses = flightClassDao.getAllFlightClass();
		if(flightClasses == null) {
			try {
				throw new BusinessException("No flight details Available");
			} catch (BusinessException e) {
				System.out.println(e.getMessage());
			}
		}
		return flightClassDao.getAllFlightClass();
		
	}

	@Override
	public void deleteFlightClass(String flightClassId)  {
			flightClassDao.deleteFlightClass(flightClassId);
		
	}

	@Override
	public void updateFlightClass(FlightClass flightClass)   {
			flightClassDao.updateFlightClass(flightClass);
		
	}

	@Override
	public void addFlightClass(FlightClass flightClass)   {
		if(flightClass.getNumberOfSeats()==30) {
		flightClassDao.addFlightClass(flightClass);
		}
	}

	@Override
	public FlightClass getFlightClassById(int flightClassId)   {
		FlightClass flightClass= flightClassDao.getFlightClassById(flightClassId);
			if(flightClass==null) {
				try {
					throw new BusinessException("the requested flight is not available");
				} catch (BusinessException e) {
					e.printStackTrace();
				}
			}
			return flightClass;
		}

	@Override
	public List<FlightClass> getFlightClassByFlightId(String flightId) {
		List<FlightClass> flightClasses= flightClassDao.getFlightClassByFlightId(flightId);
		if(flightClasses==null) {
			try {
				throw new BusinessException("flightclass is not available");
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}
		return flightClasses;
	}

	@Override
	public void updateFlightClassSeatbyName(String flightId, String flightClass) {
		
		
		flightClassDao.updateFlightClassSeatbyName(flightId, flightClass);
		
	}
		
	@Override
	public void incrementFlightClassSeatbyName(String flightId, String flightClass) {
		
		
		flightClassDao.incrementFlightClassSeatbyName(flightId, flightClass);
		
	}
	}

	

		

