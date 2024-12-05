package com.jbk.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.JobApplication;

@Repository
public class JobApplicationDaoImpl implements JobApplicationDaoInterface {

	@Autowired
	SessionFactory sessionfactory;
	@Override
	public int createJobApplication(JobApplication jobapplication) {
		try {
			 Session session = sessionfactory.openSession();
			 JobApplication dbjobapp = session.get(JobApplication.class, jobapplication.getId());
			 if(dbjobapp == null) {
				 session.save(jobapplication);
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
	public int updateStatus(long id , String status) {
		JobApplication jobapplication = new JobApplication();
		Session session  = null;
		Transaction transaction = null;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			JobApplication existingJob = session.get(JobApplication.class, jobapplication.getId());
		     if(existingJob != null) {
		    	 existingJob.setStatus(jobapplication.getStatus());
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
