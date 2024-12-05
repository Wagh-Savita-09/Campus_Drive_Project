package com.jbk.entity;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.jbk.Enum.InterviewStatus;



@Entity
@Table(name = "interview")
public class Interview {

	@Id
	@Column(name = "id", nullable = false, unique = true)
	@NotNull(message = "id is not null")
	private long id;
	
	@Column(name = "student_id", nullable = false)
	@NotNull(message = "student id is null")
	private long student_id;
	
	@Column(name = "job_application_id", nullable = false)
	@NotNull(message = "job application id is null")
	private long job_application_id;
	
	@Column(name = "interview_date",nullable = false)
	@NotNull(message = "interview data is empty is null")
	private Date interview_date;

	@Column(name = "interview_status",nullable = false)
	private String interview_status = InterviewStatus.SCHEDULED.getValue();
	
	
	public Interview() {
		// TODO Auto-generated constructor stub
	}


	public Interview(@NotNull(message = "is is not null") long id, @NotEmpty(message = "") long student_id,
			long job_application_id, Date interview_date, String interview_status) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.job_application_id = job_application_id;
		this.interview_date = interview_date;
		this.interview_status = interview_status;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getStudent_id() {
		return student_id;
	}


	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}


	public long getJob_application_id() {
		return job_application_id;
	}


	public void setJob_application_id(long job_application_id) {
		this.job_application_id = job_application_id;
	}


	public Date getInterview_date() {
		return interview_date;
	}


	public void setInterview_date(Date interview_date) {
		this.interview_date = interview_date;
	}


	public String getInterview_status() {
		return interview_status;
	}


	public void setInterview_status(String interview_status) {
		this.interview_status = interview_status;
	}


	@Override
	public String toString() {
		return "Interview [id=" + id + ", student_id=" + student_id + ", job_application_id=" + job_application_id
				+ ", interview_date=" + interview_date + ", interview_status=" + interview_status + "]";
	}


	
	
	
}

