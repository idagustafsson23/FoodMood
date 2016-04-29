package com.foodmood.models;

import java.util.ArrayList;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RecipeComponent {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	private String componentName;
	private ArrayList<String> componentDescription;
	private ArrayList<Ingredient> componentIngredients; 
	
	public RecipeComponent() {
		componentDescription = new ArrayList<String>();
		componentIngredients = new ArrayList<Ingredient>();
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public ArrayList<String> getComponentDescription() {
		return componentDescription;
	}

	public void setComponentDescription(ArrayList<String> componentDescription) {
		this.componentDescription = componentDescription;
	}

	public ArrayList<Ingredient> getComponentIngredients() {
		return componentIngredients;
	}

	public void setComponentIngredients(ArrayList<Ingredient> componentIngredients) {
		this.componentIngredients = componentIngredients;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
