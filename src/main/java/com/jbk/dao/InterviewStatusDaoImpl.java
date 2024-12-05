package com.jbk.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.Exception.ResourseNotFoundException;
import com.jbk.entity.Interview;

@Repository
public class InterviewStatusDaoImpl implements InterviewStatusDaoInterface {

	@Autowired
	SessionFactory sessionfactory;
	@Override
	public int interviewSchedule(Interview interview) {
		try {
			Session session = sessionfactory.openSession();
			Interview dbinfo = session.get(Interview.class, interview.getId());
			if(dbinfo == null) {
				session.save(interview);
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
	public Interview getinterviewschedule(long id) {
		Interview interview  = null;
		
			Session session = sessionfactory.openSession();
			interview= session.get(Interview.class, id);
			if(interview != null) {
				return interview;
			}else {
				throw new ResourseNotFoundException("student not found for this id"); 
		
	}
 
	}
	
	}
