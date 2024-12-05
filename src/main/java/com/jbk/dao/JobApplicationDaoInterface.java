package com.jbk.dao;

import com.jbk.entity.JobApplication;

public interface JobApplicationDaoInterface {
	
 public int createJobApplication(JobApplication jobapplication);
  
 public int updateStatus(long id ,String status);
}
