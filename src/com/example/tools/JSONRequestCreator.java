package com.example.tools;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.example.phr.model.Client;

public class JSONRequestCreator {

	Context context;

	public JSONRequestCreator(Context context) {
		this.context = context;
	}

	public String createJSONRequest(Object object, String message)
			throws JSONException {
		JSONObject json = new JSONObject();

		if (object.getClass().equals(JSONObject.class))
			json.put("data", object);
		else
			json.put("data", GSONConverter.convertObjectToJSON(object));
		json.put("message", message);

		JSONObject auth = new JSONObject();
		Client clientAuth = getClientAuthentication();
		auth.put("clientID", clientAuth.getClientID());
		auth.put("clientPassword", clientAuth.getClientPassword());

		json.put("auth", auth);

		return json.toString();
	}

	private static Client getClientAuthentication() {
		return null;
	}
}
