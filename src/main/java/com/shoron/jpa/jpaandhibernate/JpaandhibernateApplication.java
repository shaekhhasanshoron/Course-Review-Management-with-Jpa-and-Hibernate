package com.shoron.jpa.jpaandhibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shoron.jpa.jpaandhibernate.model.Course;
import com.shoron.jpa.jpaandhibernate.model.FullTimeEmployee;
import com.shoron.jpa.jpaandhibernate.model.PartTimeEmployee;
import com.shoron.jpa.jpaandhibernate.model.Review;
import com.shoron.jpa.jpaandhibernate.model.Student;
import com.shoron.jpa.jpaandhibernate.repository.CourseRepository;
import com.shoron.jpa.jpaandhibernate.repository.EmployeeRepository;
import com.shoron.jpa.jpaandhibernate.repository.StudentRepository;

@SpringBootApplication
public class JpaandhibernateApplication implements CommandLineRunner{

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(JpaandhibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		Course course = courseRepository.findById(1001L);
//		logger.info("Course Details {}", course);
//		
//		courseRepository.save(new Course("CSE423"));
		
		// courseRepository.deleteById(1001L);
		
		//courseRepository.changeUsingEntityManager();
		
		//studentRepository.saveStudentWithPassport();
		
	
		
//		List<Review> reviews = new ArrayList<>();
//		reviews.add(new Review("4", "Nice work"));
//		reviews.add(new Review("3", "Well Done"));
//		
//		courseRepository.addReviewsForCourse(1003L,reviews);
		
		//studentRepository.insertStudentandCourse();
		
		//studentRepository.insertStudentandCourse(new Student("Jack"), new Course("ENG091"));
		
		employeeRepository.insert(new FullTimeEmployee("Joe", new BigDecimal("10000")));
		
		employeeRepository.insert(new PartTimeEmployee("Mike", new BigDecimal("20")));
		
		logger.info("All employees -> {}", employeeRepository.retrieveAllEmployees());
	}
}
