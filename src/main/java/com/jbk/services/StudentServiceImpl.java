package com.jbk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.StudentDaoImpl;
import com.jbk.dao.StudentDaoInterface;
import com.jbk.entity.Student;

@Service
public class StudentServiceImpl implements StudentServiceInterface {

	@Autowired
	StudentDaoInterface studentdaointerface;
	
	@Override
	public int registerStudent(Student student) {
		int stdintfo =studentdaointerface .registerStudent(student);
		return stdintfo;
	}

	@Override
	public int createMultipleStudentd(List<Student> liststudent) {
		int student = studentdaointerface.createMultipleStudentd(liststudent);
		return student;
	}

	@Override
	public int updateSudentInfo(Student student) {
		int status = studentdaointerface.updateSudentInfo(student);
		return status;
		
		
	}
	
	
	
	@Override
	public Student getStudentByStudentid(long std_id) {
		Student student = studentdaointerface.getStudentByStudentid(std_id);
		return student;
	}

	@Override
	public int deleteStudentById(long std_id) {
		 int status= studentdaointerface.deleteStudentById(std_id);
		return status;
		
		
	}

	@Override
	public List<Student> fetchAllStudent() {
		
		return studentdaointerface.fetchAllStudent();
	}

}
