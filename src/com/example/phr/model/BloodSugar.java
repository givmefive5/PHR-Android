package com.example.phr.model;

import java.math.BigDecimal;

public class BloodSugar {
	//in mg/dL
	long id;
	BigDecimal glucoseLevel;
	String description;

	public BloodSugar(long id, BigDecimal glucoseLevel, String description) {
		super();
		this.id = id;
		this.glucoseLevel = glucoseLevel;
		this.description = description;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public BigDecimal getGlucoseLevel() {
		return glucoseLevel;
	}
	public void setGlucoseLevel(BigDecimal glucoseLevel) {
		this.glucoseLevel = glucoseLevel;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
