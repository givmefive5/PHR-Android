package com.example.phr.daoimpl;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.example.phr.dao.UserDao;
import com.example.phr.exceptions.UserAlreadyExistsException;
import com.example.phr.exceptions.WebServerException;
import com.example.phr.local_db.DatabaseHandler;
import com.example.phr.model.AccessTokenObject;
import com.example.phr.model.User;
import com.example.tools.EncryptionHandler;
import com.example.tools.GSONConverter;
import com.example.tools.Hasher;
import com.example.tools.JSONRequestCreator;

public class UserDaoImpl extends BasicDaoImpl implements UserDao {

	private Context context;

	public UserDaoImpl(Context applicationContext) {
		context = applicationContext;
	}

	@Override
	public void registerUser(User user) throws WebServerException,
			UserAlreadyExistsException {

		try {
			String command = "user/register";
			JSONObject userJSON = GSONConverter.convertObjectToJSON(user);

			String jsonToSend = JSONRequestCreator.createJSONRequest(userJSON,
					null);

			JSONObject response = performHttpRequest_JSON(command, jsonToSend);
			System.out.println(response.getJSONObject("data"));
			if (response.get("status").equals("fail"))
				throw new WebServerException(
						"An error has occurred while communicating"
								+ "with the web server.");
			else if (response.getJSONObject("data")
					.has("usernameAlreadyExists")
					&& response.getJSONObject("data")
							.get("usernameAlreadyExists").equals("true")) {
				System.out.println("Username already exists");
				throw new UserAlreadyExistsException(
						"User already exists in the database");
			} else {
				String userAccessToken = response.getJSONObject("data")
						.getString("userAccessToken");
				System.out.println(userAccessToken);
				setAccessToken(userAccessToken, user.getUsername());

			}
		} catch (JSONException e) {
			Log.e("exception", e.getMessage());
			throw new WebServerException("Error in parsing JSON", e);
		} catch (Exception e) {
			throw new WebServerException("Error in processing the request", e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean validateUser(String username, String password)
			throws WebServerException {

		try {
			String command = "user/validateLogin";

			Map<String, String> map = new HashMap<String, String>();
			map.put("username", username);

			String hashedPassword = Hasher.hash(password);
			map.put("hashedPassword", hashedPassword);

			String jsonToSend = JSONRequestCreator.createJSONRequest(map, null);
			JSONObject response = performHttpRequest_JSON(command, jsonToSend);

			if (response.get("status").equals("fail"))
				throw new WebServerException(
						"An error has occurred while communicating"
								+ "with the web server.");

			if (response.getJSONObject("data").get("isValid").equals("true")) {
				String userAccessToken = response.getJSONObject("data")
						.getString("userAccessToken");
				System.out.println(userAccessToken);
				setAccessToken(userAccessToken, username);
				System.out.println(getAccessToken());
				return true;
			} else if (response.getJSONObject("data").get("isValid")
					.equals("false")) {
				return false;
			}
			throw new WebServerException(
					"An error has occurred while communicating"
							+ "with the web server.");
		} catch (JSONException e) {
			throw new WebServerException("An error has occurred while parsing"
					+ "the web server response.");
		} catch (Exception e) {
			throw new WebServerException(
					"An error has occurred while processing the request.");
		}
	}

	@Override
	public User getUserGivenUsername(String username) throws WebServerException {
		return null;
	}

	@Override
	public String getAccessToken() throws Exception {
		DatabaseHandler db = new DatabaseHandler(context);
		AccessTokenObject token = db.getAccessToken();
		String encryptedToken = token.getAccessToken();
		return EncryptionHandler.decrypt(encryptedToken);
	}

	@Override
	public void setAccessToken(String accessToken, String username) throws Exception {
		DatabaseHandler db = new DatabaseHandler(context);
		String encryptedToken = EncryptionHandler.encrypt(accessToken);
		db.setAccessToken(encryptedToken, username);

	}
}
