package com.mphasis.jarvis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.jarvis.util.StringPrefixedSequenceIdGenerator;
@Entity
@DynamicInsert
@DynamicUpdate
public class Ticket {
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "tic_seq")
	@GenericGenerator(name = "tic_seq", 
	strategy = "com.mphasis.jarvis.util.StringPrefixedSequenceIdGenerator", 
	parameters = {
	@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "4"),
	@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "TI_"),
	@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
@Column(updatable = false, nullable = false) 
private String ticketId;

	@Column(length=10,nullable=false, columnDefinition="default varchar 'booked'",insertable=false) 
	private String ticketStatus;


@OneToOne
@JoinColumn(name="passengerId")
private Passenger passenger;


public Passenger getPassenger() {
	return passenger;
}
public void setPassenger(Passenger passenger) {
	this.passenger = passenger;
}


public String getTicketId() {
	return ticketId;
}
public void setTicketId(String ticketId) {
	this.ticketId = ticketId;
}
public String getTicketStatus() {
	return ticketStatus;
}
public void setTicketStatus(String ticketStatus) {
	this.ticketStatus = ticketStatus;
}

}
