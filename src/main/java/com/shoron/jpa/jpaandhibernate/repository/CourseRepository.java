package com.shoron.jpa.jpaandhibernate.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoron.jpa.jpaandhibernate.model.Course;

@Repository
@Transactional
public class CourseRepository {
 //Repository talks to db
	
	@Autowired
	EntityManager em;	
	
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
	
}
