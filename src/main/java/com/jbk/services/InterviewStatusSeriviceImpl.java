package com.jbk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.InterviewStatusDaoInterface;
import com.jbk.entity.Interview;

@Service
public class InterviewStatusSeriviceImpl implements InterviewStatusServiceInterface {

	@Autowired
	InterviewStatusDaoInterface interviewstatusdaointerface;
	@Override
	public int interviewSchedule(Interview interview) {
		int status = interviewstatusdaointerface.interviewSchedule(interview);
		return status;
	}
	@Override
	public Interview getinterviewschedule(long id) {
    Interview interview	= interviewstatusdaointerface.getinterviewschedule(id);
		return interview;
	}

}
