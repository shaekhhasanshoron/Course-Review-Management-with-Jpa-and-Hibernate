package com.shoron.jpa.jpaandhibernate.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shoron.jpa.jpaandhibernate.JpaandhibernateApplication;
import com.shoron.jpa.jpaandhibernate.model.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaandhibernateApplication.class)
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Test
	public void contextLoads() {
		Course course = repository.findById(1001L);
		
		assertEquals("ECO101", course.getName());
		
		logger.info("Test is running");
	}

}
