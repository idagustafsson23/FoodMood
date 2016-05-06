package com.foodmood.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	private String recipeName;
	
	private ArrayList<String> recipeDescription;
	
	@OneToMany(cascade = {CascadeType.PERSIST})
	private List<RecipeComponent> recipeComponents;
	
	/* need to map this as @onetomany, otherwise no relation will be made to ingridients table. 
	 * use private set<Ingredient> recipeIngredients with annotation
	 */
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Ingredient> recipeIngredients;
	
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
	
	public void setFoodTag(FoodTag foodTag) {
		this.foodTag = foodTag;
	}
	
	
	public FoodTag getFoodTag() {
		return foodTag;
	}
	
}
