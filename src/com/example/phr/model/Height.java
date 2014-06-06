package com.example.phr.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Height {

	long id;
	BigDecimal heightInInches;
	Date date;
	String description;
	
	public Height(long id, BigDecimal heightInInches, Date date, String description) {
		super();
		this.id = id;
		this.heightInInches = heightInInches;
		this.date = date;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getHeightInInches() {
		return heightInInches;
	}

	public void setHeightInInches(BigDecimal heightInInches) {
		this.heightInInches = heightInInches;
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
