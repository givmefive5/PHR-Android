package com.example.phr.model;

import java.sql.Date;

import android.graphics.drawable.Drawable;

public class BloodPressure {
	// in millimeters of mercury
	int id;
	int systolic;
	int diastolic;
	String date;
	String time;
	Drawable image;
	String description;
	
	public BloodPressure()
	{
		
	}

	public BloodPressure(int id, int systolic, int diastolic, String date,String time,
			String description,  Drawable image) {
		super();
		this.id = id;
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.date = date;
		this.description = description;
		this.time = time;
		this.image = image;
	}

	public BloodPressure(int systolic, int diastolic, String date,String time,
			String description) {
		super();
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.date = date;
		this.description = description;
		this.time = time;
	}

	public Drawable getImage() {
		return image;
	}

	public void setImage(Drawable image) {
		this.image = image;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public long getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
