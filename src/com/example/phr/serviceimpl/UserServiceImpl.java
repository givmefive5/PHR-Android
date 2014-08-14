package com.example.phr.serviceimpl;

import com.example.phr.dao.UserDao;
import com.example.phr.daoimpl.UserDaoImpl;
import com.example.phr.exceptions.DatabaseErrorException;
import com.example.phr.exceptions.DuplicateUserException;
import com.example.phr.exceptions.ServiceException;
import com.example.phr.exceptions.UserAlreadyExistsException;
import com.example.phr.model.User;
import com.example.phr.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();

	@Override
	public void registerUser(User user) throws DuplicateUserException,
			ServiceException, UserAlreadyExistsException {
		try {
			userDao.registerUser(user);
		} catch (DatabaseErrorException e) {
			throw new ServiceException("Error in registration", e);
		}
	}

	@Override
	public boolean validateUserLogin(User user) throws ServiceException {
		try {
			return userDao.validateUserLogin(user);
		} catch (DatabaseErrorException e) {
			throw new ServiceException("An error occured in the user service",
					e);
		}
	}

	@Override
	public User getUserGivenUsername(String username) throws ServiceException {
		try {
			return userDao.getUserGivenUsername(username);
		} catch (DatabaseErrorException e) {
			throw new ServiceException("An error occured in the user service",
					e);
		}
	}
}
