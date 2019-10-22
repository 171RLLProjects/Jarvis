package com.mphasis.jarvis.daos;

import java.util.List;

import com.mphasis.jarvis.entities.Passenger;

public interface PassengerDao {
	    public void registerPassenger(Passenger passenger);
	    public List<Passenger> getAllPassenger();
	    public void cancelPassenger(String passengerId);
		public Passenger getPassengerById(String passengerId);
	    
}
