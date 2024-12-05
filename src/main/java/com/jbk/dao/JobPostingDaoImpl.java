package com.jbk.dao;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.Exception.ResourseNotFoundException;
import com.jbk.entity.JobPosting;
import com.jbk.entity.Student;

@Repository
public class JobPostingDaoImpl implements JobPostingDaoInterface {

	@Autowired
	private SessionFactory sessionfactory;
	JobPosting jobposting1 = new JobPosting();
	
	@Override
	public int createJobPosting(JobPosting jobposting) {
		 Session session = sessionfactory.openSession();
		 try {
//		 String hql = "FROM jobPosting WHERE job_title =: job_title AND company_name =: company_name  AND job_location =: job_location";
//		 Query<JobPosting> query = session.createQuery(hql, JobPosting.class);
//		 query.setParameter("job_title", jobposting.getJob_title());
//		 query.setParameter("company_name", jobposting.getCompany_name());
//		 query.setParameter("job_location", jobposting.getJob_location());
//		 
//		 JobPosting existingjobpost = query.uniqueResultOptional().orElse(null);
			 
			 
//			  JobPosting dbjobpost = session.get(JobPosting.class, jobposting.getCompany_name());
//			  JobPosting dbjobpost2 = session.get(JobPosting.class, jobposting.getJob_title());
//			  JobPosting dbjobpost3 = session.get(JobPosting.class, jobposting.getJob_location());
//			  List<JobPosting> existingjobpost = new LinkedList<JobPosting>();
//			  existingjobpost.add(dbjobpost);
//			  existingjobpost.add(dbjobpost2);
//			  existingjobpost.add(dbjobpost3);
			 
//			 CriteriaBuilder builder = session.getCriteriaBuilder();
//		        CriteriaQuery<JobPosting> criteria = builder.createQuery(JobPosting.class);
//		        Root<JobPosting> root = criteria.from(JobPosting.class);
//
//		        criteria.select(root)
//		                .where(
//		                    builder.equal(root.get("job_title"), jobposting.getJob_title()),
//		                    builder.equal(root.get("company_name"), jobposting.getCompany_name()),
//		                    builder.equal(root.get("job_location"), jobposting.getJob_location())
//		                );

		        // Execute the query
//		        JobPosting existingJobPost = session.createQuery(criteria).uniqueResult();

			 JobPosting dbjobPost =  session.get(JobPosting.class, jobposting.getJob_id());
			  
		 if(dbjobPost == null) {
				session.save(jobposting);
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
	public JobPosting getJobPostingInfoById(long job_id) {
		JobPosting jobposting = null;
		
		Session session = sessionfactory.openSession();
		 jobposting = session.get(JobPosting.class, job_id);
		 if(jobposting != null) {
			 return jobposting;
		 }else {
			 throw new ResourseNotFoundException("Not user found for this id :" +job_id);
		 }
		
//		try {
//			Session session = sessionfactory.openSession();
//			 jobposting = session.get(JobPosting.class, id);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return jobposting;
//	}
	}





	@Override
	public List<JobPosting> fetchAllJobPosting() {
		Session  session = sessionfactory.openSession();
		
			try {
			
			String hql = "FROM JobPosting";
			Query<JobPosting> querry = session.createQuery(hql, JobPosting.class);
			return querry.getResultList();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}





	@Override
	public int deleteJobPosting(long job_id) {
	Session session  =	sessionfactory.openSession();
	JobPosting jobposting = null;
	try {
		JobPosting dbjobpost =  session.get(JobPosting.class, job_id);
		if(dbjobpost != null) {
			session.delete(dbjobpost);
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
	public int updateJobPosting(JobPosting jobposting) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			  session = sessionfactory.openSession();
			JobPosting existingJob = session.get(JobPosting.class,jobposting.getJob_id());
			if(existingJob != null) {
				existingJob.setJob_title(jobposting.getJob_title());
				existingJob.setCompany_name(jobposting.getCompany_name());
				existingJob.setJob_location(jobposting.getJob_location());
				existingJob.setEligibility_criteria(jobposting.getEligibility_criteria());
				existingJob.setJob_description(jobposting.getJob_description());
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


