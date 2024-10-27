package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.StudentDao;
import com.jsp.entity.Student;
import com.jsp.exceptionClass.InvalidAge;
import com.jsp.exceptionClass.InvalidPhone;

@Component(value = "service")
public class StudentService {
	@Autowired
	private StudentDao dao;

	public Student saveStudent(Student student) {
		long phone = student.getPhone();
		if (phone > 999999999 && phone <= 9999999999L) {
			if (student.getAge() >= 15) {
				dao.SaveStudent(student);
				return student;
			} else {
				throw new InvalidAge("Student Age is Invalid");
			}
		} else {
			throw new InvalidPhone("Student Phone is Invalid");
		}

	}
	public Student findById(int id) {
		return dao.findStudentByid(id);
	}
	
	
	public boolean deleteById(int id) {
		return dao.deleteStudentById(id);
	}
	
	public Student updateStudent(Student student ,int id) {
		long phone = student.getPhone();
		if (phone > 999999999 && phone <= 9999999999L) {
			if (student.getAge() >= 15) {
				dao.updateStudent(id, student);
				return student;
			} else {
				throw new InvalidAge("Student Age is Invalid");
			}
		} else {
			throw new InvalidPhone("Student Phone is Invalid");
		}

	}
	public List<Student> getAllStudent(){
		return dao.getAllStudent();
	}
	public Student getStudentByName(String name) {
		return dao.getStudentByName(name);
	}
}
