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
		} catch (JSONException e) {
			throw new DatabaseErrorException("Error in parsing JSON", e);
		}
	}

	@Override
	public boolean validateUser(String username, String password)
			throws DatabaseErrorException {

		// try {
		// String command = "user/validate";
		// JSONObject jsonObj = new JSONObject();
		// jsonObj.put("username", username);
		// jsonObj.put("password", password);
		// JSONObject response = performHttpRequest_JSON(command,
		// jsonObj.toString());
		//
		// if (response.getString("isValid").equals("true"))
		// return true;
		// else if (response.getString("isValid").equals("false"))
		// return false;
		// else
		// throw new DatabaseErrorException("Cannot perform action");
		// } catch (JSONException e) {
		// throw new DatabaseErrorException("Cannot perform action", e);
		// }
		return false;
	}

	@Override
	public User getUserGivenUsername(String username)
			throws DatabaseErrorException {
		return null;
	}
}
