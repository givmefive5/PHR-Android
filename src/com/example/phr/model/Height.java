package com.example.phr.model;

import java.sql.Date;

public class Height {
	
	long id;
	double heightInCm;
	String heightInInch;
	Date date;
	String heightMonth;
	String heightDay;
	String description;
	String heightTime;
	
	
	
	public Height(long id, double heightInCm, String heightInInch, Date date,
			String heightMonth, String heightDay, String description,
			String heightTime) {
		super();
		this.id = id;
		this.heightInCm = heightInCm;
		this.heightInInch = heightInInch;
		this.date = date;
		this.heightMonth = heightMonth;
		this.heightDay = heightDay;
		this.description = description;
		this.heightTime = heightTime;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getHeightInCm() {
		return heightInCm;
	}
	public void setHeightInCm(double heightInCm) {
		this.heightInCm = heightInCm;
	}
	public String getHeightInInch() {
		return heightInInch;
	}
	public void setHeightInInch(String heightInInch) {
		this.heightInInch = heightInInch;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getHeightMonth() {
		return heightMonth;
	}
	public void setHeightMonth(String heightMonth) {
		this.heightMonth = heightMonth;
	}
	public String getHeightDay() {
		return heightDay;
	}
	public void setHeightDay(String heightDay) {
		this.heightDay = heightDay;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHeightTime() {
		return heightTime;
	}
	public void setHeightTime(String heightTime) {
		this.heightTime = heightTime;
	}
	
	
	
	
}
