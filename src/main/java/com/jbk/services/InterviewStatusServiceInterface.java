package com.jbk.services;

import com.jbk.entity.Interview;

public interface InterviewStatusServiceInterface {

	public int interviewSchedule(Interview interview);
	public Interview getinterviewschedule(long id);
}
