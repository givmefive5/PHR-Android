package com.example.phr.dao;

import com.example.phr.exceptions.DatabaseErrorException;

public interface UserDao {

	public boolean verifyUser(String username, String password) throws DatabaseErrorException;
}
