package com.mphasis.jarvis.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FlightClass {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int flightClassId;
	private String flightClass;
	private int numberOfSeats;
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	@ManyToOne
	@JoinColumn(name="flightId")
	private Flight flight;
	
	public int getFlightClassId() {
		return flightClassId;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public void setFlightClassId(int flightClassId) {
		this.flightClassId = flightClassId;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	

}
