package com.jbk.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.User;
import com.jbk.services.UserServiceInterface;

@RestController
@RequestMapping("/user")
public class UserContoller {

	@Autowired
	UserServiceInterface userServiceInterface;
	
	@PostMapping("/create-user")
	public String createUser(@RequestBody @Valid User user) {
		
		int status = userServiceInterface.createUser(user);
		
		switch(status) {
		
		case 1:{
			return " user Added Successfully";
		}
		case 2:{
			return "Alresdy exist";
		}
		case 3 : {
		return "Something went wrong";
		}
		default:
			return " " ;
	}
		
}
	
	
	
	
	
	@GetMapping("/get-user/{username}")
	public User getUserByUsername(@PathVariable String username) {
		
		User user = userServiceInterface.getUserByUsername(username);
		return user;
	}
	
	
	
	
	
	
	
	@DeleteMapping("/delete-user")
	public Object deleteuserByUsername(@RequestParam String username) {
		int status = userServiceInterface.deleteUserByUsername(username);
		
		switch(status) {
		
		case 1:{
		return "User Delete successfully";
		}
		case 2:{
			return "User not found for this username";
		}
		case 3:{
			return "Something went wrong";
		}
		default:
			return " ";
		
	}
		
	}
	
	
	
	
	
	
	@PostMapping("create-multipleuser")
	public String createMultipleUsers(@RequestBody List<User> userlist) {
		int status = userServiceInterface.createMultipleUsers(userlist);
		
		switch(status) {
		case 1:{
			return "users added successfully";
		}
		case 2:{
			return "already exist";
		}
		case 3:{
			return "something went wrong";
		}
		default:{
			return "";
		}
		}
		
	}
	
	
	
	
	@PutMapping("update-user")
	public String updateUserInfo(@RequestBody User user) {
    int status  = userServiceInterface.updateUserInfo(user);
	switch(status) {
	case 1:{
		return "Updated successfully";
	}
	case 2:{
		return "user not found for this name";
	}
	case 3:{
		return "something went wrong";
	}
	default:
		return " ";
	}
	}
	
}