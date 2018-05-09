package com.shoron.jpa.jpaandhibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
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
	public void findById() {
		Course course = repository.findById(1001L);
		
		assertEquals("ECO101", course.getName());
	}

	@Test
	@DirtiesContext  // after test run spring will automatically reset data
	public void deleteById() {
		
		repository.deleteById(1002L);
		
		assertNull(repository.findById(1002L));
	}

}
