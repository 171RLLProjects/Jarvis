package com.mphasis.jarvis.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.jarvis.entities.Passport;
import com.mphasis.jarvis.service.PassportServices;


@RestController
public class PassportController {
	@Autowired
	PassportServices passportServices;

	@RequestMapping(value="/passport",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Void> insertPassport(@RequestBody Passport passport) {
		Map<String,String>  response=new HashMap<String, String>();    
		try {
		passportServices.addPassport(passport);
		 }
        catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

	@RequestMapping(value="/passport/{passportId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Passport> retrivePassportById(@PathVariable("passportId") String passportId) {

		Passport passport=null;
		try {
		passport=passportServices.getPassportById(passportId);
		}catch(Exception e)
		{
			return new ResponseEntity<Passport>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.accepted().body(passport);
		
	}

	@RequestMapping(value="/passport",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Passport>> getAllPassport(){

		List<Passport> passport=null;
		try {
		passport=passportServices.getAll();
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return ResponseEntity.ok().body(passport);
	}

}
