package com.example.phr.dao;

import com.example.exceptions.DatabaseErrorException;

public interface UserDao {

	public boolean verifyUser(String username, String password) throws DatabaseErrorException;
}
