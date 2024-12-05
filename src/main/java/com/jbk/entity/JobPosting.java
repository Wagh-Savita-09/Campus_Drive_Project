
package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class JobPosting {

	@Id
	@Column(name = "job_id" , nullable = false , unique = true)
	@NotNull(message = " invalid id")
	private long job_id;
	
	@Column(name = "job_title" , nullable = false)
	@NotBlank(message = "Job title is empty.")
	private String job_title;
	
	@Column(name = "company_name" , nullable = false)
	@NotBlank(message = "company name is empty.")
	private String company_name;
	
	@Column(name = "job_description" , nullable = false)
	@NotBlank(message = "job description is empty.")
	private String job_description;
	
	@Column(name = "job_location" , nullable = false)
	@NotBlank(message = "job location is empty.")
	private String job_location;
	
	@Column(name = "eligibility_criteria" , nullable = false)
	@NotBlank(message = "eligibility criteria is empty.")
	private String eligibility_criteria;
	
	public JobPosting() {
		// TODO Auto-generated constructor stub
	}

	public JobPosting(long job_id, String job_title, String company_name, String job_description, String job_location,
			String eligibility_criteria) {
		super();
		this.job_id = job_id;
		this.job_title = job_title;
		this.company_name = company_name;
		this.job_description = job_description;
		this.job_location = job_location;
		this.eligibility_criteria = eligibility_criteria;
	}

	public long getJob_id() {
		return job_id;
	}

	public void setJob_id(long job_id) {
		this.job_id = job_id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getJob_description() {
		return job_description;
	}

	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}

	public String getJob_location() {
		return job_location;
	}

	public void setJob_location(String job_location) {
		this.job_location = job_location;
	}

	public String getEligibility_criteria() {
		return eligibility_criteria;
	}

	public void setEligibility_criteria(String eligibility_criteria) {
		this.eligibility_criteria = eligibility_criteria;
	}

	@Override
	public String toString() {
		return "JobPosting [job_id=" + job_id + ", job_title=" + job_title + ", company_name=" + company_name
				+ ", job_description=" + job_description + ", job_location=" + job_location + ", eligibility_criteria="
				+ eligibility_criteria + "]";
	}

	
	
	
	
	
 }
