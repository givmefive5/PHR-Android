package com.example.phr.daoimpl;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.example.phr.dao.UserDao;
import com.example.phr.exceptions.IPBlockedException;
import com.example.phr.exceptions.UserAlreadyExistsException;
import com.example.phr.exceptions.WebServerException;
import com.example.phr.local_db.DatabaseHandler;
import com.example.phr.model.AccessToken;
import com.example.phr.model.User;
import com.example.tools.EncryptionHandler;
import com.example.tools.GSONConverter;
import com.example.tools.Hasher;
import com.example.tools.JSONRequestCreator;

public class UserDaoImpl extends HTTPSDaoImpl implements UserDao {

	private Context context;

	private JSONRequestCreator jsonRequestCreator;

	public UserDaoImpl(Context context) {
		this.context = context;
		jsonRequestCreator = new JSONRequestCreator(context);
	}

	@Override
	public void registerUser(User user) throws WebServerException,
			UserAlreadyExistsException {

		try {
			String command = "user/register";
			JSONObject userJSON = GSONConverter.convertObjectToJSON(user);

			String jsonToSend = jsonRequestCreator.createJSONRequest(userJSON,
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
				setAccessToken(new AccessToken(userAccessToken,
						user.getUsername()));

			}
		} catch (JSONException e) {
			Log.e("exception", e.getMessage());
			throw new WebServerException("Error in parsing JSON", e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean validateUser(String username, String password)
			throws WebServerException, IPBlockedException {

		try {
			String command = "user/validateLogin";

			Map<String, String> map = new HashMap<String, String>();
			map.put("username", username);

			String hashedPassword = Hasher.hash(password);
			map.put("hashedPassword", hashedPassword);

			String jsonToSend = jsonRequestCreator.createJSONRequest(map, null);
			JSONObject response = performHttpRequest_JSON(command, jsonToSend);

			if (response.get("status").equals("fail")
					&& response.getJSONObject("data").has("isBlocked")
					&& response.getJSONObject("data").getString("isBlocked")
							.equals("true"))
				throw new IPBlockedException(
						"Due to multiple logins, IP is currently blocked");
			else if (response.get("status").equals("fail")) {
				throw new WebServerException(
						"An error has occurred while communicating"
								+ "with the web server.");
			}
			System.out.println(response);
			if (response.getJSONObject("data").get("isValid").equals("true")) {
				String userAccessToken = response.getJSONObject("data")
						.getString("userAccessToken");
				System.out.println(userAccessToken);
				setAccessToken(new AccessToken(userAccessToken, username));
				System.out.println(getAccessToken().getAccessToken()
						+ getAccessToken().getUserName());
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
		}
	}

	@Override
	public User getUserGivenUsername(String username) throws WebServerException {
		return null;
	}

	@Override
	public AccessToken getAccessToken() {
		DatabaseHandler db = new DatabaseHandler(context);
		AccessToken token = db.getAccessToken();
		String decryptedToken = EncryptionHandler.decrypt(token
				.getAccessToken());
		token.setAccessToken(decryptedToken);
		return token;
	}

	@Override
	public void setAccessToken(AccessToken accessToken) {
		DatabaseHandler db = new DatabaseHandler(context);
		String encryptedToken = EncryptionHandler.encrypt(accessToken
				.getAccessToken());
		accessToken.setAccessToken(encryptedToken);
		db.setAccessToken(accessToken);

	}
}
