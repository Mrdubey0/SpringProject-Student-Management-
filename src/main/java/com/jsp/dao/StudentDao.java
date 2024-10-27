package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.jsp.entity.Student;
@Component
public class StudentDao {
	@Autowired
	private EntityManager em; 
	
	
	////Method to Create the Student Object from DataBase
	public void SaveStudent(Student student) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(student);
		et.commit();
		
		
	}
	////Method to Find the Student Object from DataBase
	public Student findStudentByid(int id) {
		return em.find(Student.class, id);
		
	}
	
	//Method to Delete the Student Object from DataBase
	public boolean deleteStudentById(int id) {
	    Student dbStudent = findStudentByid(id);
	    
	    if (dbStudent != null) {
	        EntityTransaction et = em.getTransaction();
	        
	        try {
	            et.begin();
	            em.remove(dbStudent);
	            et.commit();
	            System.out.println("Successfully Deleted Student for ID: " + id);
	            return true;
	            
	        } 
	        catch (Exception e) {
	            System.err.println("Error while deleting student: " + e.getMessage());
	            return false;
	        }
	    } 
	    else {    
	        System.err.println("Cannot Find Student for ID: " + id);
	        return false;
	    }
	}

//	public boolean deleteStudentById(int id) {
//		Student dbStudent  = findStudentByid(id);
//		Optional<Student> op = Optional.ofNullable(dbStudent);
//		System.out.println(op.get());
//		if(op.isPresent()) {
//			EntityTransaction et = em.getTransaction();
//			et.begin();
//			em.remove(op.get());
//			et.commit();
//			System.out.println("Sucessfully Deleted Student for ID:-"+id);
//			return true;
//		}
//		else
//		{	
//			System.err.println("Cannot Find Student for ID:-"+id);
//			return false;
//		}
//	}
	////Method to Update the Student Object from DataBase
	public Student updateStudent (int id , Student updateStudent) {
		Student dbStudent = findStudentByid(id);
		if(dbStudent != null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			updateStudent.setId(id);
			em.merge(updateStudent);
			et.commit();
			return updateStudent;
		}
		else {
			return null;
		}
	}
	public List<Student> getAllStudent(){
		String query = "select s from Student s";
		Query q = em.createQuery(query);
		List<Student> s = q.getResultList();
		return s;
	}
	public Student getStudentByName(String name) {
		String query = "select s from Student s where s.name=?1";
		TypedQuery<Student> qt= em.createQuery(query, Student.class);
		qt.setParameter(1, name);
		Student s = qt.getSingleResult();
		return s;
	}
}
