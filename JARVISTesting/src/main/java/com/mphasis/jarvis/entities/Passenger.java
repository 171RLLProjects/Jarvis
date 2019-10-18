package com.mphasis.jarvis.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mphasis.jarvis.util.StringPrefixedSequenceIdGenerator;

@Entity
@DynamicInsert
@DynamicUpdate
public class Passenger {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "pas_seq")
	@GenericGenerator(name = "pas_seq", 
	strategy = "com.mphasis.jarvis.entities.StringPrefixedSequenceIdGenerator", 
	parameters = {
	@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
	@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PS_"),
	@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	private String passengerId;
	@Column(length=10,nullable=false)
	private String passengerName;
	@Column(length=3,nullable=false)
	private int passengerAge;
	@Column(length=10,nullable=false)
	private String passengerGender;
	@Column(length=10,nullable=false)
	private int passengerSeatno;
	@Column(length=10,columnDefinition="date default sysdate")
	private String bookingDate;
	@OneToOne
	@JoinColumn(name="passportNum")
	private Passport passport;
	@ManyToOne
	@JoinColumn(name="flightId")
	private Flight flight;
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public String getPassengerGender() {
		return passengerGender;
	}
	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}
	public int getPassengerSeatno() {
		return passengerSeatno;
	}
	public void setPassengerSeatno(int passengerSeatno) {
		this.passengerSeatno = passengerSeatno;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	

	
}
