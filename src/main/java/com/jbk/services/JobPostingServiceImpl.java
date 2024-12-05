package com.jbk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.JobPostingDaoInterface;
import com.jbk.entity.JobPosting;

@Service
public class JobPostingServiceImpl implements JobPostingServiceInterface {

	@Autowired
	JobPostingDaoInterface jobpostingdaointerface;
	@Override
	public int createJobPosting(JobPosting jobposting) {
		
	int jobinfo = jobpostingdaointerface.createJobPosting(jobposting);
		return 0;
	}
	@Override
	public JobPosting getJobPostingInfoById(long id) {
		JobPosting status = jobpostingdaointerface.getJobPostingInfoById(id);
		return status;
	}
	@Override
	public List<JobPosting> fetchAllJobPosting() {
		return  jobpostingdaointerface.fetchAllJobPosting();
		
	}
	@Override
	public int deleteJobPosting(long job_id) {
		int status = jobpostingdaointerface.deleteJobPosting(job_id);
		return status;
	}
	@Override
	public int updateJobPosting(JobPosting jobposting) {
		int status = jobpostingdaointerface.updateJobPosting(jobposting);
		return status;
	}

}
