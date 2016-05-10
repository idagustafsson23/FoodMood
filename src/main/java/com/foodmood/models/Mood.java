package com.foodmood.models;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mood {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	private String theMood;
	private ArrayList<String> grapesForMood;
	
	public Mood() {
		grapesForMood = new ArrayList<String>();
	}
	
	public void setGrapesForMood(ArrayList<String> grapesForMood) {
		this.grapesForMood = grapesForMood;
	}
	public void setTheMood(String theMood) {
		this.theMood = theMood;
	}
	public ArrayList<String> getGrapesForMood() {
		return grapesForMood;
	}
	public Long getId() {
		return id;
	}
	public String getTheMood() {
		return theMood;
	}
	
}
