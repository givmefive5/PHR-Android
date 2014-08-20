package com.example.phr.daoimpl;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.example.phr.dao.BloodPressureDao;
import com.example.phr.dao.UserDao;
import com.example.phr.exceptions.WebServerException;
import com.example.phr.model.BloodPressure;
import com.example.tools.GSONConverter;
import com.example.tools.JSONRequestCreator;

public class BloodPressureDaoImpl extends BasicDaoImpl implements
		BloodPressureDao {

	UserDao userDao;
	Context context;
	
	public BloodPressureDaoImpl(Context context){
		this.context = context;
		userDao = new UserDaoImpl(context);
	}

	@Override
	public void addBloodPressure(BloodPressure bloodPressure)
			throws WebServerException {
		String command = "tracker/addBloodPressure";

		try {
			JSONObject data = new JSONObject();
			data.put("accessToken", userDao.getAccessToken());
			data.put("bloodPressure",
					GSONConverter.convertObjectToJSON(bloodPressure));
			String jsonToSend = JSONRequestCreator
					.createJSONRequest(data, null);
			JSONObject response = performHttpRequest_JSON(command, jsonToSend);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
