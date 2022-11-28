package com.tyb.dao;

import java.sql.SQLException;

import com.tyb.bean.User;

public interface IUserDao {

	User getUserByNameAndPassword(String name, String password) throws SQLException;
	User getUserByName(String name) throws SQLException;
	boolean addUser(User user) throws SQLException;
	
}
