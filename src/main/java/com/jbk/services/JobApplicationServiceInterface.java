package com.jbk.services;

import com.jbk.entity.JobApplication;

public interface JobApplicationServiceInterface {

	public int createJobApplication(JobApplication jobapplication);
	
	public int updateStatus(long id, String status);
}
