package com.example.phr.model;

import android.graphics.drawable.Drawable;

public class Medicine {

	String medicineName;
	String intakeStatus;
	String purpose;
	String frequency;
	String prescribedByDoctor;
	String startDate;
	String endDate;
	String rxNumber;
	private Drawable imgMedicine;
	
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getIntakeStatus() {
		return intakeStatus;
	}
	public void setIntakeStatus(String intakeStatus) {
		this.intakeStatus = intakeStatus;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getPrescribedByDoctor() {
		return prescribedByDoctor;
	}
	public void setPrescribedByDoctor(String prescribedByDoctor) {
		this.prescribedByDoctor = prescribedByDoctor;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getRxNumber() {
		return rxNumber;
	}
	public void setRxNumber(String rxNumber) {
		this.rxNumber = rxNumber;
	}
	public Drawable getImgMedicine() {
		return imgMedicine;
	}
	public void setImgMedicine(Drawable imgMedicine) {
		this.imgMedicine = imgMedicine;
	}
	
}