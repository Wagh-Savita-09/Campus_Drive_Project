package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jbk.entity.Interview;
import com.jbk.services.InterviewStatusServiceInterface;

@RestController
@RequestMapping("/interview")
public class InterviewStatusController {

	@Autowired
	InterviewStatusServiceInterface interviewstatusserviseinterface;
	@PostMapping("/schedule")
	public String interviewSchedule(@RequestBody Interview interview) {
		
		int status = interviewstatusserviseinterface.interviewSchedule(interview);
		
		switch(status) {
		case 1:{
			return "confirm interview schedule";
		}
		case 2:{
			return "this  schedule is alredy busy";
		}
		case 3:{
			return "something went wrong";
		}
		default:
			return " ";
		}
		
	}
   
	@GetMapping("/get-interviewer-info/{id}")
	public Interview getinterviewschedule(@PathVariable long id) {
		Interview interview =  interviewstatusserviseinterface.getinterviewschedule(id);
		return interview ;
	}
	
 }
