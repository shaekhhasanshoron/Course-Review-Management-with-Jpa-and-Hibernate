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
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	private String rating;
	
	private String description;
	
	
	//Jpa should have aempty constructor
	public Review(){		
	}
	
	public Review(String rating, String description) {
		super();
		this.rating = rating;
		this.description = description;
	}
	// only can get
	public Long getId() {
		return id;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}
	
	
	
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", description=" + description + "]";
	}



	
}
