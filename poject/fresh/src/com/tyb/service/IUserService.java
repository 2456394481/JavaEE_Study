package com.tyb.service;

import java.sql.SQLException;

import com.tyb.bean.User;

public interface IUserService {

	

	User getUserByNameAndPassword(String name, String password) throws SQLException;
	/**
	 * 注册
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	boolean register(User user ) throws SQLException;
}
