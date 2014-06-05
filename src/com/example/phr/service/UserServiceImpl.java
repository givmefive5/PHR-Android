package com.example.phr.service;

import com.example.exceptions.DatabaseErrorException;
import com.example.phr.dao.UserDao;
import com.example.phr.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();
	
	@Override
	public boolean verifyUser(String username, String password) {
		try {
			return userDao.verifyUser(username, password);
		} catch (DatabaseErrorException e) {
			e.printStackTrace();
			
			return false;
		}
	}

}
