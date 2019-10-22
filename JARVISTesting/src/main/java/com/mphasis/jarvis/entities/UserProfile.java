package com.mphasis.jarvis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.jarvis.util.StringPrefixedSequenceIdGenerator;

@Entity
public class UserProfile {	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "use_seq")
	@GenericGenerator(name = "use_seq", 
	strategy = "com.mphasis.jarvis.util.StringPrefixedSequenceIdGenerator", 
	parameters = {
	@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
	@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CU_"),
	@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d") })
	@Column(updatable = false, nullable = false) 
	private String userId;
	@Column(length=10,nullable=false, unique=true)
	private String userName;
	@Column(length=10,nullable=false)
	private String userPass;
	@Column(length=10,nullable=false)
	private String dob;
	@Column(length=10,nullable=false)
	private String gender;
	@Column(length=30,nullable=false)
	private String presentAddress;
	@Column(length=30,nullable=false)
	private String permanentAddress;
	@Column(length=10,nullable=false)
	private long mobileNo;
	@Column(length=20,nullable=false)
	private String email;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
