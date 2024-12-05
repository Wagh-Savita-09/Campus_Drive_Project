package com.jbk.dao;


import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.jbk.DTO.LoginData;
import com.jbk.Exception.ResourseNotFoundException;
import com.jbk.entity.User;
import com.jbk.services.UserServiceInterface;

@Repository
public class UserDaoImpl implements UserDaoInterface {

	@Autowired
	private SessionFactory sessionfactory;	
	@Override
	public int createUser(User user) {
		Session session = sessionfactory.openSession();
	 User dbuser = session.get(User.class, user.getUsername());
		try {
			if(dbuser == null) {
			session.save(user);
			session.beginTransaction().commit();
			return 1;
			}else {
				return 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
	
	
}
	
	@Override
	public User getUserByUsername(String username) {
		User user = null;
		
		
			
			Session session = sessionfactory.openSession();
			 user = session.get(User.class,username);
			 
			 if(user != null) {
				 return user;
			 }else {
				throw new ResourseNotFoundException("User is not found for this username "+username); 
			 }	
	}

	@Override
	public int deleteUserByUsername(String username) {
		
			Session session = sessionfactory.openSession();
			User dbuser = session.get(User.class, username);
			try {
				
				if(dbuser != null) {
					session.delete(dbuser);
					session.beginTransaction().commit();
					return 1;
				}else {
					return 2;
				}
			
		}catch(Exception e) {
			e.printStackTrace();
			return 3;
		}
		
		
	}

	@Override
	public User loginUser(LoginData logindata) {
		try {
			Session session = sessionfactory.openSession();
			User dbuser = session.get(User.class, logindata.getUsername());
			if(dbuser != null) {
				if(dbuser.getPassword().equals(logindata.getPassword())) {
					return dbuser;
				}
			}else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int createMultipleUsers(List<User> userlist) {
		 Session session = sessionfactory.openSession();
		 try {
		 if(userlist != null && !userlist.isEmpty()) {
			 for(User user : userlist) {
			session.save(user);
			session.beginTransaction().commit();
			
			 }
			 return 1;
		 }else {
			 return 2;
		 }
		 
		
	}catch(Exception e) {
		e.printStackTrace();
		return 3;
	}
		
  }

	@Override
	public int updateUserInfo(User user) {
		Session session = null;
		Transaction transaction = null;
	
		try {
		  session = sessionfactory.openSession();
		  transaction = session.beginTransaction();
		 User existinguser = session.get(User.class, user.getUsername());
		 if(existinguser != null) {
			 existinguser.setUsername(user.getUsername());	 
		 existinguser.setPassword(user.getPassword());
		 existinguser.setQuestion(user.getQuestion());
		 existinguser.setAnswer(user.getAnswer());
		 existinguser.setRole(user.getRole());
		 
		 transaction.commit();
			 return 1;
		 }else {
			 return 2;
		 }
		 }catch(Exception e) {
			 e.printStackTrace();
			 return 3;
		 }
		
	}
	
	
}
	


