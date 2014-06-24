package com.example.phr.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Weight {
	// in pounds
	long id;
	BigDecimal weight;
	Date date;
	String description;

	public Weight(long id, BigDecimal weight, Date date, String description) {
		super();
		this.id = id;
		this.weight = weight;
		this.date = date;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
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
