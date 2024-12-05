package com.jbk.dao;

import java.util.List;

import com.jbk.DTO.LoginData;
import com.jbk.entity.User;

public interface UserDaoInterface {

	
	public int createUser(User user);
	
	public User getUserByUsername(String username);

	public int deleteUserByUsername(String username);

	 
	 public User loginUser(LoginData logindata);
	 
	 public int createMultipleUsers(List<User> userlist);
	 
	 public int updateUserInfo(User user);
}
