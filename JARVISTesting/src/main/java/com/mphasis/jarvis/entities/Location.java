package com.mphasis.jarvis.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.jarvis.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "loc_seq")
	@GenericGenerator(name = "loc_seq", 
	strategy = "com.mphasis.jarvis.entities.StringPrefixedSequenceIdGenerator", 
	parameters = {
	@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
	@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "LOC"),
	@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	private String locId;
	
	private String lname;

	public String getLocId() {
		return locId;
	}

	public void setLocId(String locId) {
		this.locId = locId;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	

}
