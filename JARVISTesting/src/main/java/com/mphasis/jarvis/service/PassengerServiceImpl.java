package com.mphasis.jarvis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.jarvis.daos.PassengerDao;
import com.mphasis.jarvis.entities.Passenger;
import com.mphasis.jarvis.exceptions.BusinessException;

@Service
public class PassengerServiceImpl implements PassengerService {
	@Autowired
	
 PassengerDao passengerDao ;	

	@Override
	public void registerPassenger(Passenger passenger){
	/*	try {
		if(passenger.getPassengerName().matches("[A-Za-z]")) {
			*/
			passengerDao.registerPassenger(passenger);
		/*}else {
			throw new BusinessException("Invalid name");
		}
		}catch (BusinessException e) {
			 System.out.println(e.getMessage());
        }*/
	}

	@Override
	public List<Passenger> getAllPassenger() {
		List<Passenger> passengers = passengerDao.getAllPassenger();
        if(passengers == null) {
            try {
                throw new BusinessException("Invalid passenger details");
            } catch (BusinessException e) {
                System.out.println(e.getMessage());
            }
        }
		return passengerDao.getAllPassenger();
	}

	@Override
	public void cancelPassenger(String passengerId) {
		passengerDao.cancelPassenger(passengerId);
		
	}

	@Override
	public Passenger getPassengerById(String passengerId) {
	
		return passengerDao.getPassengerById(passengerId);
	}
	}
