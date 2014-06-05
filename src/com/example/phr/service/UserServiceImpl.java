package com.example.phr.service;

import com.example.phr.dao.UserDao;
import com.example.phr.dao.UserDaoImpl;
import com.example.phr.exceptions.DatabaseErrorException;
import com.example.phr.exceptions.ServiceException;
import com.example.phr.model.User;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();
	
	@Override
	public boolean verifyUser(String username, String password) throws ServiceException {
		try {
			return userDao.verifyUser(username, password);
		} catch (DatabaseErrorException e) {
			throw new ServiceException("An error occured in the user service", e);
		}
	}

	@Override
	public User getUserGivenUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
