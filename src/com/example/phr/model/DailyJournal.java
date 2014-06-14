package com.example.phr.model;

import android.graphics.drawable.Drawable;

public class DailyJournal {
	
	private String weight;
	private String calories;
	private String activities;
	private String date;
	private Drawable imgUrl;
	
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getCalories() {
		return calories;
	}
	public void setCalories(String calories) {
		this.calories = calories;
	}
	public String getActivities() {
		return activities;
	}
	public void setActivities(String activities) {
		this.activities = activities;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Drawable getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(Drawable imgUrl) {
		this.imgUrl = imgUrl;
	}

}
