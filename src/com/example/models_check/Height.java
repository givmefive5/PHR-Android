package com.example.models_check;

import java.math.BigDecimal;
import java.sql.Date;

public class Height {

	long id;
	double heightInCm;
	String heightInInch;
	String heightDate;
	String heightDay;
	String heightMonth;
	String heightDescription;
	String heightTime;
	
	
	
	
	public Height(long id, double heightInCm, String heightInInch,
			String heightDate, String heightDay, String heightMonth,
			String heightDescription, String heightTime) {
		super();
		this.id = id;
		this.heightInCm = heightInCm;
		this.heightInInch = heightInInch;
		this.heightDate = heightDate;
		this.heightDay = heightDay;
		this.heightMonth = heightMonth;
		this.heightDescription = heightDescription;
		this.heightTime = heightTime;
	}
	public String getHeightDay() {
		return heightDay;
	}
	public void setHeightDay(String heightDay) {
		this.heightDay = heightDay;
	}
	public String getHeightMonth() {
		return heightMonth;
	}
	public void setHeightMonth(String heightMonth) {
		this.heightMonth = heightMonth;
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
	public String getHeightDate() {
		return heightDate;
	}
	public void setHeightDate(String heightDate) {
		this.heightDate = heightDate;
	}
	public String getHeightDescription() {
		return heightDescription;
	}
	public void setHeightDescription(String heightDescription) {
		this.heightDescription = heightDescription;
	}
	public String getHeightTime() {
		return heightTime;
	}
	public void setHeightTime(String heightTime) {
		this.heightTime = heightTime;
	}
	
	
	
	
}
