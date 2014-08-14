package com.example.phr.daoimpl;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.phr.dao.UserDao;
import com.example.phr.exceptions.DatabaseErrorException;
import com.example.phr.exceptions.UserAlreadyExistsException;
import com.example.phr.model.User;
import com.example.tools.GSONConverter;

public class UserDaoImpl extends BasicDaoImpl implements UserDao {

	@Override
	public void registerUser(User user) throws DatabaseErrorException,
			UserAlreadyExistsException {
		String command = "user/register";
		String jsonParams = GSONConverter.convertObjectToJSON(user);
		JSONObject response = performHttpRequest_JSON(command, jsonParams);
		try {
			if (response.get("status").equals("error"))
				throw new UserAlreadyExistsException(
						"User already exists in the database");
			else {
				throw new UserAlreadyExistsException(
						"HHHHHHHHHHHHHHHHHHsadasasasas");
			}
		} catch (JSONException e) {
			throw new DatabaseErrorException("Error in parsing JSON", e);
		}
	}

	@Override
	public boolean validateUserLogin(User user) throws DatabaseErrorException {

		try {
			String command = "user/validate";
			String jsonParams = GSONConverter.convertObjectToJSON(user);
			JSONObject response = performHttpRequest_JSON(command, jsonParams);
			System.out.println(response);
			System.out.println(response.getString("status"));
			if (response.getString("status").equals("success")) {
				boolean isValid = response.getJSONObject("data").getBoolean(
						"isValid");
				System.out.println(isValid);
				return isValid;
			}
			throw new DatabaseErrorException("Something went wrong.");
		} catch (JSONException e) {
			e.printStackTrace();
			throw new DatabaseErrorException(
					"Cannot perform action, json was not parsed correctly", e);
		}
	}

	@Override
	public User getUserGivenUsername(String username)
			throws DatabaseErrorException {
		return null;
	}
}
