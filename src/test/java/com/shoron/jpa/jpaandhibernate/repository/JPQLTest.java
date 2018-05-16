package com.shoron.jpa.jpaandhibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
import com.shoron.jpa.jpaandhibernate.model.Student;

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
	
	@Test
	public void jpql_students_with_passport_having_certain_pattern(){
		
		TypedQuery<Student> query = em.createQuery("Select s from Student s where s.passport.number like '%56%'", Student.class);
		
		List<Student> resultList = query.getResultList();
		
		logger.info("Students with passport number having 56 -> {}", resultList);
	}
	
	
	@Test
	public void join(){
		// it is not a typed query because it does not have a single type
		Query query = em.createQuery("Select c, s from Course c JOIN c.students s");
		
		List<Object[]> resultList = query.getResultList();
		
		logger.info("Join table result size -> {}", resultList.size());
		
		for(Object[] result: resultList){
			// result is a array of an array
			logger.info("Course {} Student {}",
					result[0] // course
					, result[1] // students
					);
			
		}
	}
	
	@Test
	public void left_join(){
		// it is not a typed query because it does not have a single type
		Query query = em.createQuery("Select c, s from Course c LEFT JOIN c.students s");
		
		List<Object[]> resultList = query.getResultList();
		
		logger.info("Join table result size -> {}", resultList.size());
		
		for(Object[] result: resultList){
			// result is a array of an array
			logger.info("Course {} Student {}",
					result[0] // course
					, result[1] // students
					);
			
		}
	}
	
	@Test
	public void cross_join(){
		// it is not a typed query because it does not have a single type
		Query query = em.createQuery("Select c, s from Course c, Student s");
		
		List<Object[]> resultList = query.getResultList();
		
		logger.info("Join table result size -> {}", resultList.size());
		
		for(Object[] result: resultList){
			// result is a array of an array
			logger.info("Course {} Student {}",
					result[0] // course
					, result[1] // students
					);
			
		}
	}
}
