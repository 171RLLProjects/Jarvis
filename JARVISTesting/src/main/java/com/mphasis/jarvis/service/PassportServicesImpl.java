package com.mphasis.jarvis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.jarvis.daos.PassportDao;
import com.mphasis.jarvis.entities.Passport;
import com.mphasis.jarvis.exceptions.BusinessException;

@Service
public class PassportServicesImpl implements PassportServices {
	@Autowired
	PassportDao passportDao;
	@Override
	public void addPassport(Passport passport) {	
		
			try {
				passportDao.add(passport);
			} catch (Exception e) {

				e.getMessage();
			}
		
	}


	@Override
	public Passport getPassportById(String passportId) {

		Passport passport=passportDao.getPassportById(passportId);	
		if(passport.getPassportId()==null) {
			try {
				throw new BusinessException("Passport is Not Available!!!!!!");
			} catch (BusinessException e) {

				e.getMessage();
			}
		}
		return passport;
	}

	@Override
	public List<Passport> getAll() {

		List<Passport> passport=passportDao.getAll();
		if(passport == null) {
			try {
				throw new BusinessException("No Passports Are Available!!!!!!!");
			} catch (BusinessException e) {				
				e.getMessage();
			}
		}


		return passport;
	}

}
