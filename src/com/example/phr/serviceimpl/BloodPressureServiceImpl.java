package com.example.phr.serviceimpl;

import com.example.phr.dao.BloodPressureDao;
import com.example.phr.daoimpl.BloodPressureDaoImpl;
import com.example.phr.exceptions.ServiceException;
import com.example.phr.exceptions.WebServerException;
import com.example.phr.model.BloodPressure;
import com.example.phr.service.BloodPressureService;

public class BloodPressureServiceImpl implements BloodPressureService {

	BloodPressureDao bloodPressureDao = new BloodPressureDaoImpl();

	@Override
	public void addBloodPressure(BloodPressure bloodPressure)
			throws ServiceException {
		try {
			bloodPressureDao.addBloodPressure(bloodPressure);
		} catch (WebServerException e) {
			throw new ServiceException("Error in adding blood pressure", e);
		}
	}

}
