package com.mphasis.jarvis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mphasis.jarvis.entities.Passenger;
@Service
public interface PassengerService {
    public void registerPassenger(Passenger passenger);
    public List<Passenger> getAllPassenger();
	 public void cancelPassenger(String passengerId);
		public Passenger getPassengerById(String passengerId);

}
