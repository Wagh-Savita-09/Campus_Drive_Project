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
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.JobPosting;
import com.jbk.services.JobPostingServiceInterface;

@RestController
@RequestMapping("/jobposting")
public class JobPostingController {

	@Autowired
	JobPostingServiceInterface jobpostingserviceinterface;
	@PostMapping("/create-jobposting")
	public String createJobPosting(@RequestBody @Valid JobPosting jobposting) {
		 int status = jobpostingserviceinterface.createJobPosting(jobposting);
		
		 switch(status) {
		 case 1:{
			 return "Job posted successfully";
		 }
		 case 2:{
			 return "Job is already posted";
		 }
		 case 3:{
			 return "something went wrong";
		 }
		 default:
			 return "";
		}
		
		
	}
	
	@GetMapping("/get-jobinfo")
	public Object getJobPostingInfoById(@PathVariable long id) {
		try {
			 JobPosting jobposting = jobpostingserviceinterface.getJobPostingInfoById(id);
			 if(jobposting !=  null) {
				 return jobposting;
			 }else {
				 return "There is no job post available for this id";
			 }
		}catch(Exception e) {
			e.printStackTrace();
			return "Something went wrong";
		}
		
		
	}
	
	
	@GetMapping("/fetch-all-jobposting")
	public List<JobPosting> fetchAllJobPosting(){
		 
		return jobpostingserviceinterface.fetchAllJobPosting();
		
	}
	
	@DeleteMapping("/delete-jobpost/{job_id}")
	public String deleteJobPosting(@PathVariable long job_id) {
		int status = jobpostingserviceinterface.deleteJobPosting(job_id);
		 switch(status) {
		 case 1:{
			 return "Job posted deleted successfully";
		 }
		 case 2:{
			 return "Job is not posted";
		 }
		 case 3:{
			 return "something went wrong";
		 }
		 default:
			 return "";
		}
		
		
	}
	
	
	@PutMapping("/update-jobposting")
	public String updateJobPosting(JobPosting jobposting) {
		int status = jobpostingserviceinterface.updateJobPosting(jobposting);
		switch(status) {
		case 1:{
			return "updated successfully";
		}
		case 2:{
			return "Job posting not found for this id";
		}
		case 3:{
			return "Something went wrong";
		}
		default :
			return " ";
		}
		
	}
	
	
}
