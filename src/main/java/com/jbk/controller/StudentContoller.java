package com.jbk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Student;
import com.jbk.services.StudentServiceInterface;



@RestController
@RequestMapping("/students")
public class StudentContoller {

	@Autowired
	StudentServiceInterface studentserviceinterface;
	
	@PostMapping("/register-student")
	public String registerStudent(@RequestBody @Valid Student student ) {
		
		
		int  status= studentserviceinterface.registerStudent(student);
		switch(status) {
		case 1:{
			return "Student added successfully";
		}
		case 2:{
			return "already exist";
		}
		case 3:{
			return "Something went wrong";
		}	
	default:
		return "";
			
		}
		
	}
	
	@GetMapping("/get-student/{std_id}")
	public Student getStudentByStudentid(@PathVariable long std_id){
		 Student student = studentserviceinterface.getStudentByStudentid(std_id);
	
		 return student;
		 
//			if(student != null) {
//				return student;
//			}else {
//				return "Student is not for name"+std_id;
//		}
	}

		
		@PostMapping("/create-multiple-std")
		public String createMultipleStudentd(@RequestBody List<Student> liststudent) {
			int status = studentserviceinterface.createMultipleStudentd(liststudent);
			switch(status) {
			case 1:{
				return "Added successfully";
			}
			case 2:{
				return "already exist";
			}
			case 3:{
				return "something went wrong";
			}
			default:
				return "";
			}
			
			
			
		}
		
		
	@PutMapping("update-student")  //
	public String updateSudentInfo(@RequestBody Student student) {
		
		int status = studentserviceinterface.updateSudentInfo(student);
		
		switch(status) {
		case 1:{
			return "Student updated successfully";
		}
		case 2:{
			return "For this id student is not exist";
		}
		case 3:{
			return "Something went wrong";
		}
		default:
			return " ";
		}
		
		
	}
	
	@DeleteMapping("/delete-student/{std_id}")
	public String deleteStudentById(@PathVariable long std_id) {
		
		int status = studentserviceinterface.deleteStudentById(std_id);
		switch(status) {
		case 1:{
			return "Deleted successfully";
		}
		case 2:{
			return "Student for this id not found";
		}
		case 3:{
			return "Something went wrong";
		}
		default:
			return "";
		}
		
	}
	
	@GetMapping("fetch-student")
	public List<Student> fetchAllStudent(){
		
		
		return studentserviceinterface.fetchAllStudent();
		
	}
	  
		
}
	

