package com.example.tools;

import org.json.JSONObject;

import com.google.gson.Gson;

public class GSONConverter {

	public static <T> T getGSONObjectGivenJsonString(String jsonString,
			Class<T> classTypeToGenerate) {
		Gson gson = new Gson();
		return gson.fromJson(jsonString, classTypeToGenerate);
	}

	public static <T> T getGSONObjectGivenJsonObject(JSONObject json,
			Class<T> classTypeToGenerate) {
		Gson gson = new Gson();
		String jsonString = json.toString();
		return gson.fromJson(jsonString, classTypeToGenerate);
	}

	public static String convertObjectToJSON(Object objectToBeConverted) {
		if (objectToBeConverted.getClass().equals(JSONObject.class))
			return objectToBeConverted.toString();
		Gson gson = new Gson();
		return gson.toJson(objectToBeConverted);
	}
}
