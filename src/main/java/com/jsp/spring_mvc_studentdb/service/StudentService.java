package com.jsp.spring_mvc_studentdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.spring_mvc_studentdb.entity.Student;
import com.jsp.spring_mvc_studentdb.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public ModelAndView addStudent(Student student) {
		//firstly save the data to the database
		studentRepository.addStudent(student);
		
		//return back to index.jsp
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.jsp");
		
		return mav;
		
	}
	
	public ModelAndView getAllStudentDetails() {
		
		//Finding all the student objects from the db
		List<Student> students = studentRepository.getAllStudentDetails();
		
		//Go to the displayStudents.jsp page carrying data
		ModelAndView mav = new ModelAndView();
		mav.setViewName("displayStudents.jsp");
		mav.addObject("key",students);
		
		return mav;
		
	}
	
	public ModelAndView updateStudent(int studentId) {
		
		Student id = studentRepository.findStudentById(studentId);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("displayToUpdateStudents.jsp");
		mav.addObject("keyId",id);
		return mav;
		
	}

	public ModelAndView updateFinalStudents(Student student) {
		
		studentRepository.updateStudent(student);
		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("display-student");
		
		return getAllStudentDetails();
	}

	public ModelAndView deleteStudent(int studentId) {
		
//		Student student = studentRepository.findStudentById(studentId);
		
		studentRepository.deleteStudent(studentId);
		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("display-student");

		return getAllStudentDetails();
		
//		return mav;
	}
	
}
