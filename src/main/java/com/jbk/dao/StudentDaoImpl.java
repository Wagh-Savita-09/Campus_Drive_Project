package com.jbk.dao;

import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.Exception.ResourseNotFoundException;
import com.jbk.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int registerStudent(Student student) {
		
		try {
			Session session = sessionFactory.openSession();
			Student dbstd = session.get(Student.class, student.getStd_id());
			if (dbstd == null) {
				session.save(student);
				session.beginTransaction().commit();
				return 1;
			} else {
				
				return 2;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
	}
	


	
	
	

	@Override
	public int createMultipleStudentd(List<Student> liststudent) {
		Session session = sessionFactory.openSession();
		
		try {
			if(liststudent != null && !liststudent.isEmpty()) {
				for(Student student:liststudent) {
					session.save(student);
					session.beginTransaction().commit();
					
				}
				return 1;
				
			}else {
				return 2;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return 3;
		}
		
		
	}




	@Override
	public int updateSudentInfo(Student student) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			 Student existStudent = session.get(Student.class, student.getStd_id());
			 if(existStudent != null) {
				 existStudent.setStd_name(student.getStd_name());
				 existStudent.setContact_number(student.getContact_number());
				 existStudent.setGraduation_year(student.getGraduation_year());
				 existStudent.setStd_email(student.getStd_email());
				 existStudent.setStd_pass(student.getStd_pass());
				 existStudent.setStd_dept(student.getStd_dept());
                 transaction.commit();
				 return 1;
			 }
			 else {
				 return 2;
			 }
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return 3;
		}finally {
			if(session.isOpen()) {
				session.close();
			}
		}
		
	}

	@Override
	public Student getStudentByStudentid(long std_id) {
		Student student = null;
		
		Session session = sessionFactory.openSession();
		student = session.get(Student.class, std_id);
		if(student != null) {
		return student;
	}else {
		throw new ResourseNotFoundException("User is notfound for this id :"+std_id);
	}
}
		
//		try {
//			
//		Session session = sessionFactory.openSession();
//		student = session.get(Student.class, std_id);
//		
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return student;
//		
//	}




	@Override
	public int deleteStudentById(long std_id) {
		Student student = null;
		try {
		Session session = sessionFactory.openSession();
		Student dbStudent= session.get(Student.class, std_id);
		if(dbStudent != null) {
			session.delete(dbStudent);
			session.beginTransaction().commit();
			return 1;
		}else {
			return 2;
		}
        
		
	}catch(Exception e) {
		e.printStackTrace();
		return 3;
	}
	
	
	}




	@Override
	public List<Student> fetchAllStudent() {
		try {
		Session session = sessionFactory.openSession();
		String hql = "FROM Student";
		Query<Student> querry = session.createQuery(hql, Student.class);
		return querry.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
 }


