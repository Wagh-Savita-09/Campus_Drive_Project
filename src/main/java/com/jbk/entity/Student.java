package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "std_id", nullable = false, unique = true)
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "Invalid id")
	private long std_id;

	@Column(name = "std_name", nullable = false)
	@NotBlank(message = "student name is empty")
	private String std_name;

	@Column(name = "std_email", nullable = false, unique = true)
	@Pattern(regexp = "^[a-zA-Z0-9]*[._%+-][a-zA-Z0-9]*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$" , message = " Email having special character @ it's manadatory...")
	private String std_email;

	@Column(name = "std_pass", nullable = false)
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$" , message=" Invalid password because password having atleast one capital letter ,having one special character and having 8 character atleast")
	private String std_pass;

	@Column(name = "contact_number", nullable = false, unique = true)
	@Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number")
	private String contact_number;

	@Column(name = "std_dept", nullable = false)
	@NotEmpty(message = "department is empty")
	private String std_dept;

	@Column(name = "graduation_year", nullable = false)
	@NotEmpty(message = "enter graduation year")
	private String graduation_year;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student( long std_id, String std_name, String std_email , String std_pass,String contact_number,String std_dept, String graduation_year) {
		super();
		this.std_id = std_id;
		this.std_name = std_name;
		this.std_email = std_email;
		this.std_pass = std_pass;
		this.contact_number = contact_number;
		this.std_dept = std_dept;
		this.graduation_year = graduation_year;
	}

	@Override
	public String toString() {
		return "Student [std_id=" + std_id + ", std_name=" + std_name + ", std_email=" + std_email + ", std_pass="
				+ std_pass + ", contact_number=" + contact_number + ", std_dept=" + std_dept + ", graduation_year="
				+ graduation_year + "]";
	}

	public long getStd_id() {
		return std_id;
	}

	public void setStd_id(long std_id) {
		this.std_id = std_id;
	}

	public String getStd_name() {
		return std_name;
	}

	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}

	public String getStd_email() {
		return std_email;
	}

	public void setStd_email(String std_email) {
		this.std_email = std_email;
	}

	public String getStd_pass() {
		return std_pass;
	}

	public void setStd_pass(String std_pass) {
		this.std_pass = std_pass;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public String getStd_dept() {
		return std_dept;
	}

	public void setStd_dept(String std_dept) {
		this.std_dept = std_dept;
	}

	public String getGraduation_year() {
		return graduation_year;
	}

	public void setGraduation_year(String graduation_year) {
		this.graduation_year = graduation_year;
	}

	
	
}
