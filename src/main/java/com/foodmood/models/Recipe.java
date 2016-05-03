package com.foodmood.models;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	private String recipeName;
	private ArrayList<String> recipeDescription;
	private ArrayList<RecipeComponent> recipeComponents;
	private ArrayList<Ingredient> recipeIngredients;
	@OneToOne(cascade = {CascadeType.ALL})
	private FoodTag foodTag;



	public Recipe() {
		recipeDescription = new ArrayList<String>();
		recipeComponents = new ArrayList<RecipeComponent>();
		recipeIngredients = new ArrayList<Ingredient>();
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public ArrayList<String> getRecipeDescription() {
		return recipeDescription;
	}

	public void setRecipeDescription(ArrayList<String> recipeDescription) {
		this.recipeDescription = recipeDescription;
	}

	public ArrayList<RecipeComponent> getRecipeComponents() {
		return recipeComponents;
	}

	public void setRecipeComponents(ArrayList<RecipeComponent> recipeComponents) {
		this.recipeComponents = recipeComponents;
	}

	public ArrayList<Ingredient> getRecipeIngredients() {
		return recipeIngredients;
	}

	public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
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
