package com.example.phr.daoimpl;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.phr.dao.UserDao;
import com.example.phr.exceptions.UserAlreadyExistsException;
import com.example.phr.exceptions.WebServerException;
import com.example.phr.model.User;
import com.example.tools.GSONConverter;
import com.example.tools.JSONRequestCreator;

public class UserDaoImpl extends BasicDaoImpl implements UserDao {

	@Override
	public void registerUser(User user) throws WebServerException,
			UserAlreadyExistsException {
		String command = "user/register";
		String jsonParams = GSONConverter.convertObjectToJSON(user);
		JSONObject response = performHttpRequest_JSON(command, jsonParams);
		try {
			if (response.get("status").equals("error"))
				throw new UserAlreadyExistsException(
						"User already exists in the database");
		} catch (JSONException e) {
			throw new WebServerException("Error in parsing JSON", e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean validateUser(String username, String hashedPassword)
			throws WebServerException {

		try {
			String command = "user/validateLogin";

			Map<String, String> map = new HashMap<String, String>();
			map.put("username", username);
			map.put("hashedPassword", hashedPassword);
			JSONObject json = JSONRequestCreator.createJSONRequest(map, null);
			JSONObject response = performHttpRequest_JSON(command,
					json.toString());
			if (response.getJSONObject("data").get("isValid").equals("true")) {
				return true;
			} else if (response.getJSONObject("data").get("isValid")
					.equals("false")) {
				return false;
			} else {
				throw new WebServerException(
						"An error has occurred while communicating"
								+ "with the web server.");
			}
		} catch (JSONException e) {
			throw new WebServerException("An error has occurred while parsing"
					+ "the web server response.");

		} catch (WebServerException e) {
			throw e;
		}
	}

	@Override
	public User getUserGivenUsername(String username) throws WebServerException {
		return null;
	}
}
