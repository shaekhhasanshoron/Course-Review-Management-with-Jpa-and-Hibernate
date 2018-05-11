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
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager em;
	
	@Test
	public void findById() {
//		Course course = repository.findById(1001L);
//		
//		assertEquals("ECO101", course.getName());
		
		List resultList = em.createQuery("Select c From Course c").getResultList();
		logger.info(" Select c From Courses c > {} ", resultList);
	}

	@Test
	public void findById_typed() {

		TypedQuery<Course> query = em.createQuery("Select c From Course c", Course.class);
		
		List<Course> resultList = query.getResultList();
		logger.info(" Select c From Courses c > {} ", resultList);
	}
	@Test
	@DirtiesContext  // after test run spring will automatically reset data
	public void deleteById() {
		
		repository.deleteById(1002L);
		
		assertNull(repository.findById(1002L));
	}
	
	@Test
	@DirtiesContext  // after test run spring will automatically reset data
	public void save() {
		
		Course course = repository.findById(1001L);
		assertEquals("ECO101", course.getName());
		
		course.setName("ENV103");
		
		repository.save(course);
		assertEquals("ENV103", course.getName());
	}
	
	@Test
	@Transactional
	public void retriveReviewsForCourse() {

		Course course = repository.findById(1001L);
		course.getReviews();
		logger.info("Course Reviews -> {}", course.getReviews());
	}
	
	@Test
	@Transactional
	public void retriveCourseForReview() {

		Review review = em.find(Review.class, 5001L);
		logger.info("Courses for 5001 review -> {}", review.getCourse());
	}

}
