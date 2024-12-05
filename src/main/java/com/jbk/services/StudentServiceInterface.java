package com.jbk.services;



import java.util.List;

import com.jbk.entity.Student;

public interface StudentServiceInterface {

	public int registerStudent(Student student);
	
	public int createMultipleStudentd(List<Student> liststudent);
	
	public int updateSudentInfo(Student student);

	public Student getStudentByStudentid(long std_id);

    public int deleteStudentById(long std_id); 
    
    public List<Student> fetchAllStudent();
}
