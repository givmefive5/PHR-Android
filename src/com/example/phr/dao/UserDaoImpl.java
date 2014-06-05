package com.example.phr.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.exceptions.DatabaseErrorException;

public class UserDaoImpl extends BasicDao implements UserDao {

	@Override
	public boolean verifyUser(String username, String password) throws DatabaseErrorException {
		
		try {
			String command = "verifyUser";
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("username", username);
			jsonObj.put("password", password);
			String response = performHttpRequest(command, jsonObj);
			JSONObject responseObj = new JSONObject(response);
			if(responseObj.getString("isValid").equals("true"))
				return true;
			else if(responseObj.getString("isValid").equals("false"))
				return false;
			else
				throw new DatabaseErrorException("Cannot perform action");
			
		} catch (JSONException e) {
			throw new DatabaseErrorException("Cannot perform action", e);
		}
		
		
	}

}
