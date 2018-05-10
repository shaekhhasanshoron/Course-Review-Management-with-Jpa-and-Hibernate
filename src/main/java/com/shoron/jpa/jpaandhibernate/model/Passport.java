package com.shoron.jpa.jpaandhibernate.model;

import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Passport {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String number;
	
	
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
	
	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}

	
}
