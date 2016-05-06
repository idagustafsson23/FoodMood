package com.foodmood.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class RecipeComponent {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;

	private String componentName;
	@Column(columnDefinition="longblob")
	private ArrayList<String> componentDescription;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@Column(columnDefinition="longblob")
	private List<Ingredient> componentIngredients; 
	
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

	public List<Ingredient> getComponentIngredients() {
		return componentIngredients;
	}

	public void setComponentIngredients(List<Ingredient> componentIngredients) {
		this.componentIngredients = componentIngredients;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
