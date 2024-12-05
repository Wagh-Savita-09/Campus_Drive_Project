package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.DTO.LoginData;
import com.jbk.entity.User;
import com.jbk.services.UserServiceInterface;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserServiceInterface userserviceinterface;

	@PostMapping("/login-user")
	public Object loginUser(@RequestBody LoginData logindata) {
		
	User user = userserviceinterface.loginUser(logindata);
		if(user != null) {
			return user;
		}else {
		return "Incorrect username or password";
		}
	}
}
