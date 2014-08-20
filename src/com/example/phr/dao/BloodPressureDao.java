package com.example.phr.dao;

import com.example.phr.exceptions.WebServerException;
import com.example.phr.model.BloodPressure;

public interface BloodPressureDao {

	void addBloodPressure(BloodPressure bloodPressure)
			throws WebServerException;

}
