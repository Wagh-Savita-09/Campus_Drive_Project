package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
	public class User {

		@Id
		@Column(name = "username", nullable = false, unique = true)
		@NotBlank(message = "Invalid username")
		private String username;

		@Column(name = "password", nullable = false)
		@Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$" , message=" Invalid password because password having atleast one capital letter ,having one special character and having 8 character atleast")
		private String password;

		@Column(name = "question", nullable = false)
		@NotEmpty(message = "Invalid question")
		private String question;

		@Column(name = "answer", nullable = false)
		@NotEmpty(message = "Invalid answer")
		private String answer;

		@Column(name = "role", nullable = false)
		@NotEmpty(message = "Invalid role")
		private String role;

		public User() {
			// TODO Auto-generated constructor stub
		}

		public User(String username, String password, String question, String answer, String role) {
			super();
			this.username = username;
			this.password = password;
			this.question = question;
			this.answer = answer;
			this.role = role;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getQuestion() {
			return question;
		}

		public void setQuestion(String question) {
			this.question = question;
		}

		public String getAnswer() {
			return answer;
		}

		public void setAnswer(String answer) {
			this.answer = answer;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		@Override
		public String toString() {
			return "User [username=" + username + ", password=" + password + ", question=" + question + ", answer=" + answer
					+ ", role=" + role + "]";
		}

	}

	

