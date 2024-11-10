package com.jsp.spring_mvc_studentdb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jsp.spring_mvc_studentdb.entity.Student;

@Repository
public class StudentRepository {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");
	
	public Student addStudent(Student student) {
		EntityManager em  = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		em.persist(student);
		
		et.commit();
		em.close();
	
		return student;
		
	}
	
	public Student findStudentById(int studentId) {
		EntityManager em  = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Student Id = em.find(Student.class, studentId);
		
		et.commit();
		em.close();
		
		return Id;
		
	}
	
	public void updateStudent(Student student) {
		EntityManager em  = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		em.merge(student);
		
		et.commit();
		em.close();
		
		
	}
	
	public void deleteStudent(int studentId) {
		EntityManager em  = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Student Id = em.find(Student.class, studentId);
		em.remove(Id);
		et.commit();
		em.close();
		
		
	}
	
	public List<Student> getAllStudentDetails() {
		EntityManager em = emf.createEntityManager();
		
		Query query  = em.createQuery("from Student student",Student.class);
		
		List<Student> students = query.getResultList();
		
		return students;
	}
	

}
