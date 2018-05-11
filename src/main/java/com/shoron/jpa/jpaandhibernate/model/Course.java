package com.shoron.jpa.jpaandhibernate.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Course {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@UpdateTimestamp // everytime it wil change the value will be updated
	private LocalDateTime lastUpdatedDate;
	
	@OneToMany(mappedBy="course")
	private List<Review> reviews = new ArrayList<>();
	
	
	@ManyToMany(mappedBy="courses") // student is the owning side of the relationship
	private List<Student> students = new ArrayList<>();
	
	//Jpa should have aempty constructor
	public Course(){		
	}
	
	public Course(String name) {
		super();
		this.name = name;
	}
	// only can get
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}
	
	public void removeReview(Review review) {
		this.reviews.remove(review);
	}
	
	

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

	
}
