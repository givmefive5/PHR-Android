package com.example.phr.exceptions;

public class DatabaseErrorException extends Exception {

	public DatabaseErrorException(String message, Exception e){
		super(message, e);
	}
	
	public DatabaseErrorException(String message){
		super(message);
	}
}
