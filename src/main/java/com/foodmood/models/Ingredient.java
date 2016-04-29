package com.foodmood.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	private String ingredientName;
	private double amountPerPortion;
	private String unitOfMeasurement;
	private FoodTag foodTag;
	
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

	public FoodTag getFoodTag() {
		return foodTag;
	}

	public void setFoodTag(FoodTag foodTag) {
		this.foodTag = foodTag;
	}

	public Long getId() {
		return id;
	}

	
	
	
}
