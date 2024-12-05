package com.jbk.dao;

import com.jbk.entity.Interview;

public interface InterviewStatusDaoInterface {

	public int interviewSchedule(Interview interview);
	
	public Interview getinterviewschedule(long id);
}
