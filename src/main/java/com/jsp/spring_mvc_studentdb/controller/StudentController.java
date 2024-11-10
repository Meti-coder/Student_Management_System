package com.jsp.spring_mvc_studentdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.spring_mvc_studentdb.entity.Student;
import com.jsp.spring_mvc_studentdb.service.StudentService;


@Controller
public class StudentController {
	
	@Autowired
	StudentService service;
	

	@RequestMapping(value="/add-student" , method =RequestMethod.POST)
	public ModelAndView addStudent(Student student) {
		
		return service.addStudent(student);
		
	}
	
	@RequestMapping(value="/display-student")
	public ModelAndView displayStudents() {
		return service.getAllStudentDetails();
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public ModelAndView updateStudents(int id) {
		return service.updateStudent(id);
	}
	
	@RequestMapping(value="/finalUpdate", method=RequestMethod.POST)
	public ModelAndView updateFinalStudents(Student student) {
		return service.updateFinalStudents(student);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView deleteStudent(int id1) {
    	return service.deleteStudent(id1);
	}

}
