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

public class BasicDao {

	public String performHttpRequest(String command, JSONObject params) throws DatabaseErrorException{
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
			throw new DatabaseErrorException("Error in database", e);
		}
	}
}
