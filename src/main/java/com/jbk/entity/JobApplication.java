package com.jbk.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.jbk.Enum.ApplicationStatus;

@Entity
public class JobApplication {

	@Id
	@Column(name = "id" , nullable = false , unique = true)
	@NotNull(message = "id is not null")
	private long id;
	
	@Column(name = "std_id", updatable = false, nullable = false)
	@NotNull(message = "std is is not null enter valid id")
	private long std_id;
	
	@Column(name = "job_postingId", nullable = false)
	@NotNull(message = "job posting id is not null enter valid id")
	private long job_postingId;
	
	private String status = ApplicationStatus.APPROVED.getValue();
	
	public JobApplication() {
		// TODO Auto-generated constructor stub
	}

	public JobApplication(long id, long std_id, long job_postingId, String status) {
		super();
		this.id = id;
		this.std_id = std_id;
		this.job_postingId = job_postingId;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStd_id() {
		return std_id;
	}

	public void setStd_id(long std_id) {
		this.std_id = std_id;
	}

	public long getJob_postingId() {
		return job_postingId;
	}

	public void setJob_postingId(long job_postingId) {
		this.job_postingId = job_postingId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "JobApplication [id=" + id + ", std_id=" + std_id + ", job_postingId=" + job_postingId + ", status="
				+ status + "]";
	}
	
	
}
