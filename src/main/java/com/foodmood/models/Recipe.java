package com.foodmood.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	private String recipeName;
	private List<String> recipeDescription;
	private List<RecipeComponent> recipeComponents;
	private List<Ingredient> recipeIngredients;
	private FoodTag preparationType;

	public FoodTag getPreparationType() {
		return preparationType;
	}

	public void setPreparationType(FoodTag preparationType) {
		this.preparationType = preparationType;
	}

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

	public List<String> getRecipeDescription() {
		return recipeDescription;
	}

	public void setRecipeDescription(List<String> recipeDescription) {
		this.recipeDescription = recipeDescription;
	}

	public List<RecipeComponent> getRecipeComponents() {
		return recipeComponents;
	}

	public void setRecipeComponents(List<RecipeComponent> recipeComponents) {
		this.recipeComponents = recipeComponents;
	}

	public List<Ingredient> getRecipeIngredients() {
		return recipeIngredients;
	}

	public void setRecipeIngredients(List<Ingredient> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}

	public Long getId() {
		return id;
	}
	
	
	
	
	
}
