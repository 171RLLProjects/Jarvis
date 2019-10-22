package com.mphasis.jarvis.daos;

import java.util.List;

import com.mphasis.jarvis.entities.Passport;

public interface PassportDao {
	public void add(Passport passport);
	public Passport getPassportById(String passportId);
	public List<Passport> getAll();
}
