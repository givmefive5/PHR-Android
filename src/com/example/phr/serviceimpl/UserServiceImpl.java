package com.example.phr.serviceimpl;

import com.example.phr.dao.UserDao;
import com.example.phr.daoimpl.UserDaoImpl;
import com.example.phr.exceptions.ServiceException;
import com.example.phr.exceptions.UserAlreadyExistsException;
import com.example.phr.exceptions.WebServerException;
import com.example.phr.model.User;
import com.example.phr.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();

	@Override
	public void registerUser(User user) throws ServiceException,
			UserAlreadyExistsException {
		try {
			userDao.registerUser(user);
		} catch (WebServerException e) {
			throw new ServiceException("Error in registration", e);
		}
	}

	@Override
	public boolean validateUser(String username, String password)
			throws ServiceException {
		try {
			return userDao.validateUser(username, password);
		} catch (WebServerException e) {
			throw new ServiceException("An error occured in the user service",
					e);
		}
	}

	@Override
	public User getUserGivenUsername(String username) throws ServiceException {
		try {
			return userDao.getUserGivenUsername(username);
		} catch (WebServerException e) {
			throw new ServiceException("An error occured in the user service",
					e);
		}
	}
}
