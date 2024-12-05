package com.jbk.dao;

import java.util.List;

import com.jbk.entity.JobPosting;

public interface JobPostingDaoInterface {

	public int createJobPosting(JobPosting jobposting);
	
	public JobPosting getJobPostingInfoById(long id);
	
	public List<JobPosting> fetchAllJobPosting();
	
	public  int deleteJobPosting(long job_id);
	
	public int  updateJobPosting(JobPosting jobposting);
}
