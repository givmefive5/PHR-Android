package com.example.phr.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import com.example.phr.exceptions.DatabaseErrorException;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public abstract class BasicDao {

	protected String performHttpRequest(String command, JSONObject params) throws DatabaseErrorException{
		String address = "http://10.0.2.2:8080/PHR-WebServer/" + command;
		try {
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(address);
			StringEntity se = new StringEntity( params.toString());  
            se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            post.setEntity(se);;
			HttpResponse response = client.execute(post);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			out.close();
			response.getEntity().writeTo(out);
			return out.toString();
		} catch (IOException e) {
			throw new DatabaseErrorException("Error in HTTP", e);
		}
	}
	
	protected <T> T getGSONObject(String response, Class<T> cls) throws DatabaseErrorException{
		try {
			Gson gson = new Gson();
			return 	gson.fromJson(response, cls);
		} catch (JsonSyntaxException e) {
			throw new DatabaseErrorException("Error in GSON", e);
		}
	}
	
}
