package com.example.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {

	public String hash(String string){
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hashed = digest.digest(string.getBytes("UTF-8"));
			return hashed.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
