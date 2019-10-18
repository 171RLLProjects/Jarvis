package com.mphasis.jarvis.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.jarvis.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ad_seq")
	@GenericGenerator(name = "ad_seq", 
	strategy = "com.mphasis.jarvis.entities.StringPrefixedSequenceIdGenerator", 
	parameters = {
	@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "2"),
	@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AD_"),
	@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d") }) 
	private String adminId;
	@Column(length=10,nullable=false)
	private String adminName;
	@Column(length=10,nullable=false)
	private String adminPass;
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	
	
	

}
