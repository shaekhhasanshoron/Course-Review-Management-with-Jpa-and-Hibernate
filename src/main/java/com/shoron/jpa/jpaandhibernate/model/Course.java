package com.shoron.jpa.jpaandhibernate.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

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
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

	
}
