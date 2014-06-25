package com.example.phr.dao;

import com.example.phr.exceptions.DatabaseErrorException;
import com.example.phr.exceptions.UserAlreadyExistsException;
import com.example.phr.model.User;

public interface UserDao {

	public boolean validateUser(String username, String password)
			throws DatabaseErrorException;

	public User getUserGivenUsername(String username)
			throws DatabaseErrorException;

	public void registerUser(User user) throws DatabaseErrorException,
			UserAlreadyExistsException;
}
