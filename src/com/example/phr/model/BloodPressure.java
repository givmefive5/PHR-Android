package com.example.phr.model;

import java.sql.Date;

public class BloodPressure {
	//in millimeters of mercury
	long id;
	int systolic;
	int diastolic;
	Date date;
	String description;
	
	public BloodPressure(long id, int systolic, int diastolic, Date date,
			String description) {
		super();
		this.id = id;
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.date = date;
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getSystolic() {
		return systolic;
	}
	public void setSystolic(int systolic) {
		this.systolic = systolic;
	}
	public int getDiastolic() {
		return diastolic;
	}
	public void setDiastolic(int diastolic) {
		this.diastolic = diastolic;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
