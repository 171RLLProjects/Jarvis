package com.mphasis.jarvis.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="schedule")
public class Schedule {
	 	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sche_seq")
	@GenericGenerator(name = "sche_seq", 
	strategy = "com.mphasis.jarvis.entities.StringPrefixedSequenceIdGenerator", 
	parameters = {
	@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "5"),
	@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "SC_"),
	@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	private String scheduleId;
	
	@Column(length=10,nullable=false)
	private String scheduleDate;
	@Column(length=10,nullable=false)
	private String scheduleTime;
	public String getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public String getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	
	
}
