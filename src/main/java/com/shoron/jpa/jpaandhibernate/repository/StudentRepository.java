package com.shoron.jpa.jpaandhibernate.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoron.jpa.jpaandhibernate.model.Passport;
import com.shoron.jpa.jpaandhibernate.model.Student;



@Repository
@Transactional
public class StudentRepository {
 //Repository talks to db
	
	@Autowired
	EntityManager em;	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Student findById(Long id){
		return em.find(Student.class, id);
	}
	
	public Student save(Student student){
		
		if(student.getId() == null ){
			//insert
			em.persist(student);
		}
		else{
			//update
			em.merge(student);
		}
		return student;
	}
	
	public void deleteById(Long id){
		Student student = findById(id);
		em.remove(student);
	}
	
	
	public void saveStudentWithPassport(){
		
		Passport passport = new Passport("20155");
		em.persist(passport);
		
		Student student = new Student("Shaon Hasan");		
		student.setPassport(passport);		
		em.persist(student);
		
		logger.info("Student -> {} ", student);
    
	}
	
}
