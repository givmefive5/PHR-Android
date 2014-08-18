package com.example.phr.serviceimpl;

import com.example.phr.dao.BloodPressureDao;
import com.example.phr.daoimpl.BloodPressureDaoImpl;
import com.example.phr.service.BloodPressureService;

public class BloodPressureServiceImpl implements BloodPressureService {

	BloodPressureDao bloodPressureDao = new BloodPressureDaoImpl();

	@Override
	public void addBloodPressure(int systolic, int diastolic) {
		bloodPressureDao.addBloodPressure(systolic, diastolic);
	}

}
