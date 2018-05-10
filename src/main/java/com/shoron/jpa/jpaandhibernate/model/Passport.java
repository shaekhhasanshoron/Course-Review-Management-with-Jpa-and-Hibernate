package com.shoron.jpa.jpaandhibernate.model;

import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Passport {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String number;
	
	//want to make student the owning side of the student passport relationship
	//that is why we have to put mappedBy in non owning side of the relationship
	@OneToOne(fetch=FetchType.LAZY, mappedBy="passport")
	private Student student;


	//Jpa should have aempty constructor
	public Passport(){		
	}
	
	public Passport(String number) {
		super();
		this.number = number;
	}
	// only can get
	public Long getId() {
		return id;
	}

	public String getnumber() {
		return number;
	}

	public void setnumber(String number) {
		this.number = number;
	}
	
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + ", student=" + student + "]";
	}
	


	
}
