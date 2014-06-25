package com.example.phr.service;

import com.example.phr.exceptions.DuplicateUserException;
import com.example.phr.exceptions.ServiceException;
import com.example.phr.model.User;

public interface UserService {

	public void registerUser(User user) throws DuplicateUserException,
			ServiceException;

	public boolean validateUser(String username, String password)
			throws ServiceException;

	public User getUserGivenUsername(String username) throws ServiceException;
}
