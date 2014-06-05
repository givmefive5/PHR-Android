package com.example.phr.service;

import com.example.phr.exceptions.ServiceException;
import com.example.phr.model.User;

public interface UserService {
	
	public boolean verifyUser(String username, String password) throws ServiceException;
	
	public User getUserGivenUsername(String username) throws ServiceException;
}
