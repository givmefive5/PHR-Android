package com.example.phr.serviceimpl;

import android.content.Context;

import com.example.phr.exceptions.OutdatedAccessTokenException;
import com.example.phr.exceptions.ServiceException;
import com.example.phr.exceptions.WebServerException;
import com.example.phr.model.BloodPressure;
import com.example.phr.service.BloodPressureService;
import com.example.phr.web.dao.BloodPressureDao;
import com.example.phr.web.daoimpl.BloodPressureDaoImpl;

public class BloodPressureServiceImpl implements BloodPressureService {

	BloodPressureDao bloodPressureDao;
	Context context;

	public BloodPressureServiceImpl(Context context) {
		this.context = context;
		bloodPressureDao = new BloodPressureDaoImpl(context);
	}

	@Override
	public void addBloodPressure(BloodPressure bloodPressure)
			throws ServiceException, OutdatedAccessTokenException {
		try {
			bloodPressureDao.addBloodPressure(bloodPressure);
		} catch (WebServerException e) {
			throw new ServiceException("Error in adding blood pressure", e);
		}
	}

}
