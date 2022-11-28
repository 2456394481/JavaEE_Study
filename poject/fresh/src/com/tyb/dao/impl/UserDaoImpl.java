package com.tyb.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.tyb.bean.User;
import com.tyb.dao.IUserDao;
import com.tyb.utils.DataSourceUtils;

public class UserDaoImpl implements IUserDao {

	@Override
	public User getUserByNameAndPassword(String name, String password) throws SQLException {
//		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		QueryRunner queryRunner = DataSourceUtils.getQueryRunner();
		String sql = "select * from user where userName=? and password=?";
		User user = queryRunner.query(sql,new BeanHandler<User>(User.class),name,password);	
		return user;
	}

	@Override
	public User getUserByName(String name) throws SQLException {
//		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		QueryRunner queryRunner = DataSourceUtils.getQueryRunner();
		String sql = "select * from user where userName=?";
		User user = queryRunner.query(sql,new BeanHandler<User>(User.class),name);	
		return user;
	}

	@Override
	public boolean addUser(User user) throws SQLException {
//		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		QueryRunner queryRunner =DataSourceUtils.getQueryRunner();
		String sql = "insert into user(userid,userName,password,email) values(null,?,?,?)";
		int row = queryRunner.update(sql,user.getUserName(),user.getPassword(),user.getEmail());
		return row>0;
	}

}
