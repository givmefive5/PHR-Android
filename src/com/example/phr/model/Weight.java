package com.example.phr.model;

import java.util.Date;

public class Weight {

	long id;
	String weightInLb;
	Date date;
	
	public Weight(long id, String weightInLb, Date date) {
		super();
		this.id = id;
		this.weightInLb = weightInLb;
		this.date = date;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getWeightInLb() {
		return weightInLb;
	}
	public void setWeightInLb(String weightInLb) {
		this.weightInLb = weightInLb;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
