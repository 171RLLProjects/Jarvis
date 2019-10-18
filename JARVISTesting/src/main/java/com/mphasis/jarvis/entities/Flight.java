package com.mphasis.jarvis.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty.Type;
import com.mphasis.jarvis.util.StringPrefixedSequenceIdGenerator;


enum FlightType{
	International, Domestic
}


@Entity
@Table(name="flight")
public class Flight {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "fl_seq")
	@GenericGenerator(name = "fl_seq", 
	strategy = "com.mphasis.jarvis.entities.StringPrefixedSequenceIdGenerator", 
	parameters = {
	@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "10"),
	@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "FL_"),
	@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	private String flightId;
	@Column(length=10,nullable=false)
	private String flightName;
	@Column(length=10,nullable=false)
	private int totalSeat;
	@Column(length=10,nullable=false)
	private int availableSeat;
	@Column(length=10,nullable=false)
	private FlightType flightType;
	@OneToMany(mappedBy="flight", fetch=FetchType.EAGER)
	@JsonIgnore
	private List<FlightClass> flightClass =new ArrayList<>();
	@ManyToOne
	@JoinColumn(name="routeId")
	private Route route;
	@ManyToOne
	@JoinColumn(name="scheduleId")
	private Schedule schedule;
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public int getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}
	public int getAvailableSeat() {
		return availableSeat;
	}
	public void setAvailableSeat(int availableSeat) {
		this.availableSeat = availableSeat;
	}
	public FlightType getFlightType() {
		return flightType;
	}
	public void setFlightType(FlightType flightType) {
		this.flightType = flightType;
	}

	public List<FlightClass> getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(List<FlightClass> flightClass) {
		this.flightClass = flightClass;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
	
	
	
	
	
	
}
