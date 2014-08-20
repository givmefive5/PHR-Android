package com.example.phr.serviceimpl;

import android.content.Context;

import com.example.phr.dao.BloodPressureDao;
import com.example.phr.daoimpl.BloodPressureDaoImpl;
import com.example.phr.exceptions.ServiceException;
import com.example.phr.exceptions.WebServerException;
import com.example.phr.model.BloodPressure;
import com.example.phr.service.BloodPressureService;

public class BloodPressureServiceImpl implements BloodPressureService {

	BloodPressureDao bloodPressureDao;
	Context context;
	
	public BloodPressureServiceImpl(Context context){
		this.context = context;
		bloodPressureDao = new BloodPressureDaoImpl(context);
	}

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
