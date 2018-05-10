package com.shoron.jpa.jpaandhibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.shoron.jpa.jpaandhibernate.JpaandhibernateApplication;
import com.shoron.jpa.jpaandhibernate.model.Course;
import com.shoron.jpa.jpaandhibernate.model.Passport;
import com.shoron.jpa.jpaandhibernate.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaandhibernateApplication.class)
public class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {

		Student student = em.find(Student.class, 2001L);
		
		logger.info("Student -> {} ", student);
		
		 logger.info("passport -> {}", student.getPassport());
	}

	
	@Test
	@Transactional // everything should succeed or nothing will be succeed
	public void test() {
		// Retrieve student 
		Student student = em.find(Student.class, 2001L);
		//Persistence Context (student)
		
		//Retrieve passport
		Passport passport = student.getPassport();
		//Persistence Context (student, passport)
		
		
		//update passport
		passport.setnumber("P458955");
		//Persistence Context (student, passport++)
		
		//update student
		student.setName("Shaekh Hasan");
		//Persistence Context (student++, passport++)
		
		
	}


}
