package com.example.phr.dao;

import com.example.phr.exceptions.DatabaseErrorException;
import com.example.phr.model.User;

public interface UserDao {

	public boolean verifyUser(String username, String password) throws DatabaseErrorException;

	public User getUserGivenUsername(String username) throws DatabaseErrorException;
}
