package com.foodmood.models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.foodmood.models.FoodTag;

@Entity
public class Wine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	private String wineSort; 
	private ArrayList<String> grapes;
	@Column(columnDefinition="longblob") 
	private ArrayList<String> foodTags;
	@Column(columnDefinition="longblob")
	private ArrayList<Integer> scoreForFoodTag;
	
	public Wine() {
		grapes = new ArrayList<String>();
		foodTags = new ArrayList<String>();
		scoreForFoodTag = new ArrayList<Integer>();
	}

	public String getWineSort() {
		return wineSort;
	}

	public void setWineSort(String wineSort) {
		this.wineSort = wineSort;
	}

	public ArrayList<String> getGrapes() {
		return grapes;
	}

	public void setGrapes(ArrayList<String> grapes) {
		this.grapes = grapes;
	}

	public ArrayList<String> getFoodTags() {
		return foodTags;
	}

	public void setFoodTags(ArrayList<String> foodTags) {
		this.foodTags = foodTags;
	}

	public ArrayList<Integer> getScoreForFoodTag() {
		return scoreForFoodTag;
	}

	public void setScoreForFoodTag(ArrayList<Integer> scoreForFoodTag) {
		this.scoreForFoodTag = scoreForFoodTag;
	}
	
	
}
