package com.jbk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.JobApplication;
import com.jbk.services.JobApplicationServiceInterface;

@RestController
@RequestMapping("/job-application")
public class JobApplicationController {

	@Autowired
	JobApplicationServiceInterface jobapplicationserviceinterface;
	@PostMapping("/create-joapplication")
	public String createJobApplication(@Valid   @RequestBody JobApplication jobapplication) {
		int status = jobapplicationserviceinterface.createJobApplication(jobapplication);
		switch(status) {
		case 1:{
			return "added successfully";
		}
		case 2:{
			return "alredy exist";
		}
		case 3:{
			return "something went wrong...";
		}
		default:
			return "";
		}
		
	}
	
	@PutMapping("/update-status/{id}/{status}")
	public String updateStatus(@PathVariable long id , @PathVariable String status) {
		int jobpost = jobapplicationserviceinterface.updateStatus(id , status);
		switch(jobpost) {
		case 1:{
			return "updated successfully";
		}
		case 2:{
			return "not found";
		}
		case 3:{
			return "something went wrong...";
		}
		default:
			return "";
		}
		
	}
}
