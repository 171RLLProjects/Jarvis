package com.mphasis.jarvis.service;

import java.util.List;

import com.mphasis.jarvis.entities.Passport;

public interface PassportServices {
	public void addPassport(Passport passport);
	public Passport getPassportById(String passportId);
	public List<Passport> getAll();
}
