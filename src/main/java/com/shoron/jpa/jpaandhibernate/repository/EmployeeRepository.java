package com.shoron.jpa.jpaandhibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoron.jpa.jpaandhibernate.model.Course;
import com.shoron.jpa.jpaandhibernate.model.Employee;
import com.shoron.jpa.jpaandhibernate.model.FullTimeEmployee;
import com.shoron.jpa.jpaandhibernate.model.PartTimeEmployee;
import com.shoron.jpa.jpaandhibernate.model.Review;

@Repository
@Transactional
public class EmployeeRepository {
 //Repository talks to db
	
	@Autowired
	EntityManager em;	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// insert an employee
	public void insert(Employee employee){
		em.persist(employee);
	}
	
	//retrieve all employee
//	public List<Employee> retrieveAllEmployees(){
//		return em.createQuery("select e from Employee e", Employee.class)
//				.getResultList();
//	}
//	
	public List<PartTimeEmployee> retrievePartTimeEmployee(){
		return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}

	public List<FullTimeEmployee> retrieveFullTimeEmployee(){
		return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}
	
}
