package com.mphasis.jarvis.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mphasis.jarvis.util.StringPrefixedSequenceIdGenerator;

@Entity
@Table(name="route")
public class Route {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "route_seq")
	@GenericGenerator(name = "route_seq", 
	strategy = "com.mphasis.jarvis.util.StringPrefixedSequenceIdGenerator", 
	parameters = {
	@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "10"),
	@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "RO_"),
	@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d") })
	@Column(updatable = false, nullable = false) 
	private String routeId;
	@ManyToOne
	@JoinColumn(name="sourceId")
	private Location source;
	@ManyToOne
	@JoinColumn(name="destinationId")
	private Location destination;
	@Column(length=10,nullable=false)
	private int distance;
	@Column(length=10,nullable=false)
	private String duration;
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	public Location getSource() {
		return source;
	}
	public void setSource(Location source) {
		this.source = source;
	}
	public Location getDestination() {
		return destination;
	}
	public void setDestination(Location destination) {
		this.destination = destination;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

	
	
	
	

	
	
	
}
