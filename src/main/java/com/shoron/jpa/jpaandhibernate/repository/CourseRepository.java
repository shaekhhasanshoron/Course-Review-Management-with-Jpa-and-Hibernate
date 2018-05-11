package com.shoron.jpa.jpaandhibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoron.jpa.jpaandhibernate.model.Course;
import com.shoron.jpa.jpaandhibernate.model.Review;

@Repository
@Transactional
public class CourseRepository {
 //Repository talks to db
	
	@Autowired
	EntityManager em;	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Course findById(Long id){
		return em.find(Course.class, id);
	}
	
	public Course save(Course course){
		
		if(course.getId() == null ){
			//insert
			em.persist(course);
		}
		else{
			//update
			em.merge(course);
		}
		return course;
	}
	
	public void deleteById(Long id){
		Course course = findById(id);
		em.remove(course);
	}
	
	
	public void changeUsingEntityManager(){
		
		Course course1 = findById(1001L);
		course1.setName("ECO103");
	}

	public void addReviewsForCourse() {
		
		Course course = findById(1003L);
		logger.info("Course Rievews -> {}", course.getReviews());
		
		// add 2 reviews 
		Review review1 = new Review("4", "Nice work");
		Review review2 = new Review("3", "Well Done");
		
		// setting the relationship
		course.addReview(review1);
		review1.setCourse(course);
		
		course.addReview(review2);
		review2.setCourse(course);
		
		// saving to review to the db
		em.persist(review1);
		em.persist(review2);
		
	}
	
	public void addReviewsForCourse(Long courseId, List<Review> reviews) {
		
		Course course = findById(courseId);
		logger.info("Course Rievews -> {}", course.getReviews());
		
		for(Review review:reviews){			
			
			// setting the relationship
			course.addReview(review);
			review.setCourse(course);

			// saving to review to the db
			em.persist(review);
		}
	}
	
}
