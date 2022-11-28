package com.tyb.bean;
/**
 *  用户对象
 * @author teng
 *
 */
public class User {
	/**
	 * 用户id
	 */
	private Integer userId;
	
	/**
	 * 用户名称
	 * 
	 */
	private String userName;
	
	/**
	 * 用户密码
	 */
	private String password;
	
	
	/**
	 * 邮箱（email）
	 */
	private String email;


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
