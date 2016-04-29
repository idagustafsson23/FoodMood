package com.foodmood.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodTag {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	public FoodTag() {
		
	}
	
	private String tagName;

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
