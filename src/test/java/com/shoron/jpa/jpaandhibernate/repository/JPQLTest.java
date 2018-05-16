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
import com.shoron.jpa.jpaandhibernate.model.Review;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaandhibernateApplication.class)
public class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager em;

	@Test
	public void jpql_course_without_students(){
		TypedQuery<Course> query = em.createQuery("Select c from Course c where c.students is empty", Course.class);
		
		List<Course> resultList = query.getResultList();
		
		logger.info("Course which do not have students -> {}", resultList);
	}
	
	@Test
	public void jpql_course_haveing_atleast_2_students(){
		
		TypedQuery<Course> query = em.createQuery("Select c from Course c where size(c.students) >= 2", Course.class);
		
		List<Course> resultList = query.getResultList();
		
		logger.info("Course have atleast 2 students -> {}", resultList);
	}
	

	@Test
	public void jpql_courses_orderBy_students(){
		
		TypedQuery<Course> query = em.createQuery("Select c from Course c order by size(c.students) desc", Course.class);
		
		List<Course> resultList = query.getResultList();
		
		logger.info("Course have atleast 2 students -> {}", resultList);
	}
	
}
