package com.jbk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jbk.DTO.LoginData;
import com.jbk.dao.UserDaoInterface;
import com.jbk.entity.User;
@Service()
@Scope("prototype")
public class UserServiceImpl implements UserServiceInterface {

	@Autowired
	UserDaoInterface usedaointerface;
	@Override
	public int createUser(User user) {
		
		int userinfo = usedaointerface.createUser(user);
		return 0;
	}
	
	
	
	@Override
	public User getUserByUsername(String username) {
		User user = usedaointerface.getUserByUsername(username);
		return user;
	}
	
	
	
	@Override
	public int deleteUserByUsername(String username) {
		int status = usedaointerface.deleteUserByUsername(username);
		return status;
		
	}
	
	
	
	
	@Override
	public User loginUser(LoginData logindata) {
		User user = usedaointerface.loginUser(logindata);
		return user;
	}
	
	
	
	@Override
	public int createMultipleUsers(List<User> userlist) {
		int status = usedaointerface.createMultipleUsers(userlist);
		return status;
	}



	@Override
	public int updateUserInfo(User user) {
		int status = usedaointerface.updateUserInfo(user);
		return status;
	}
	
	
	
	
}
