package com.jbk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.JobApplicationDaoInterface;
import com.jbk.entity.JobApplication;

@Service
public class JobApplicationServiceImpl implements JobApplicationServiceInterface {

	@Autowired
	JobApplicationDaoInterface jobapplicationdaointerface;
	@Override
	public int createJobApplication(JobApplication jobapplication) {
		int status = jobapplicationdaointerface.createJobApplication(jobapplication);
		return status;
	}
	@Override
	public int updateStatus(long id , String status) {
		int jobpost = jobapplicationdaointerface.updateStatus(id , status);
		return jobpost;
	}
	

}
