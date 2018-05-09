package com.shoron.jpa.jpaandhibernate.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoron.jpa.jpaandhibernate.model.Course;

@Repository
public class CourseRepository {
 //Repository talks to db
	
	@Autowired
	EntityManager em;	
	
	public Course findById(Long id){
		return em.find(Course.class, id);
	}
	
	//public Course save(Course course)
	
	//public void deleteById(Long id)
	
}