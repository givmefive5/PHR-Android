package com.example.phr.service;

import java.sql.Date;
import java.util.List;

import com.example.phr.model.BloodPressure;
import com.example.phr.model.User;

public interface BloodPressureService {
	
	public void addBloodPressure(User user, int systolic, int diastolic, Date date, String description);
	
	public void updateBloodPressure(BloodPressure bloodPressure);
	
	public void deleteBloodPressure(BloodPressure bloodPressure);
	
	public List<BloodPressure> getBloodPressures(User user);
	
	public BloodPressure getBloodPressureGivenBloodPressureId(long id);
}
