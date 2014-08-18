package com.example.phr.daoimpl;

import com.example.phr.dao.BloodPressureDao;
import com.example.phr.dao.UserDao;

public class BloodPressureDaoImpl implements BloodPressureDao {

	UserDao userDao = new UserDaoImpl();

	@Override
	public void addBloodPressure(int systolic, int diastolic) {
		String command = "tracker/addBloodPressure";
	}

}
