package com.example.phr.model;

import java.sql.Date;

import android.graphics.drawable.Drawable;

public class BloodPressure {
	// in millimeters of mercury
	long id;
	int systolic;
	int diastolic;
	String date;
	String time;
	String note;
	Drawable image;
	String description;

	public BloodPressure(long id, int systolic, int diastolic, String date,String time,
			String description, String note, Drawable image) {
		super();
		this.id = id;
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.date = date;
		this.description = description;
		this.time = time;
		this.note = note;
		this.image = image;
	}

	public Drawable getImage() {
		return image;
	}

	public void setImage(Drawable image) {
		this.image = image;
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
