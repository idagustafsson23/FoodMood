package com.foodmood.models;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	private String ingredientName;
	private double amountPerPortion;
	private String unitOfMeasurement;
	@OneToOne(cascade = {CascadeType.ALL})
	private FoodTag foodTag;
	
	
	//might need manytoone relation to recipe here
	
	@ManyToOne
	@JoinColumn(name = "recipeID", referencedColumnName = "id")
	private Recipe recipe;
	
	public Ingredient() {
		
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public double getAmountPerPortion() {
		return amountPerPortion;
	}

	public void setAmountPerPortion(double amountPerPortion) {
		this.amountPerPortion = amountPerPortion;
	}

	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public Long getId() {
		return id;
	}
	
	public void setFoodTag(FoodTag foodTag) {
		this.foodTag = foodTag;
	}
	
	
	public FoodTag getFoodTag() {
		return foodTag;
	}

	
}
