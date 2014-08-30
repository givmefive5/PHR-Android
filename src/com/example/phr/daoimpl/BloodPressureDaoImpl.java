package com.example.phr.daoimpl;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.example.phr.dao.BloodPressureDao;
import com.example.phr.dao.UserDao;
import com.example.phr.exceptions.OutdatedAccessTokenException;
import com.example.phr.exceptions.WebServerException;
import com.example.phr.model.BloodPressure;
import com.example.tools.GSONConverter;
import com.example.tools.JSONRequestCreator;

public class BloodPressureDaoImpl extends HTTPSDaoImpl implements
		BloodPressureDao {

	UserDao userDao;
	Context context;
	JSONRequestCreator jsonRequestCreator;

	public BloodPressureDaoImpl(Context context) {
		this.context = context;
		userDao = new UserDaoImpl(context);
		jsonRequestCreator = new JSONRequestCreator(context);
	}

	@Override
	public void addBloodPressure(BloodPressure bloodPressure)
			throws WebServerException, OutdatedAccessTokenException {
		String command = "tracker/addBloodPressure";

		try {
			JSONObject data = new JSONObject();
			data.put("accessToken", userDao.getAccessToken().getAccessToken());
			data.put("username", userDao.getAccessToken().getUserName());
			data.put("bloodPressure",
					GSONConverter.convertObjectToJSON(bloodPressure));
			String jsonToSend = jsonRequestCreator
					.createJSONRequest(data, null);
			System.out.println("JSON Request Sent: " + jsonToSend);
			JSONObject response = performHttpRequest_JSON(command, jsonToSend);
			System.out.println("JSON Response Received: " + response);
			if (response.get("status").equals("fail"))
				throw new WebServerException(
						"An error has occurred while communicating"
								+ "with the web server.");
			else if (response.getJSONObject("data").has("isValidAccessToken")
					&& response.getJSONObject("data")
							.getString("isValidAccessToken").equals("false")) {
				throw new OutdatedAccessTokenException(
						"The access token used in the request is outdated, please ask the user to log in again.");
			} else if (response.getString("status").equals("success")) {
				System.out
						.println("Adding of blood pressure successfully done!!");
			} else {
				System.out.println(response);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
