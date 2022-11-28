package com.tyb.service.impl;

import java.sql.SQLException;

import com.tyb.bean.User;
import com.tyb.dao.IUserDao;
import com.tyb.dao.impl.UserDaoImpl;
import com.tyb.service.IUserService;


public class UserServiceImpl implements IUserService {

	@Override
	public User getUserByNameAndPassword(String name, String password) throws SQLException {
		IUserDao userDao = new UserDaoImpl();
		User user =  userDao.getUserByNameAndPassword(name,password);
		return user;
	}

	@Override
	public boolean register(User user) throws SQLException {
		IUserDao userDao= new UserDaoImpl();
		User user2 = userDao.getUserByName(user.getUserName());
		if (user2!=null) {
			return false;
			
		}else {
			return userDao.addUser(user);
		}
		
	}

	

}
