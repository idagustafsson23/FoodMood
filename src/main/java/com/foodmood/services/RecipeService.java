package com.foodmood.services;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.eclipse.jdt.internal.core.CreateTypeHierarchyOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodmood.models.FoodTag;
import com.foodmood.models.Ingredient;
import com.foodmood.models.Recipe;
import com.foodmood.models.RecipeComponent;
import com.foodmood.repositories.RecipeRepository;

import scala.inline;

@Service
public class RecipeService {

		@Autowired
		private RecipeRepository recipeRepository;

		public Recipe saveRecipe(HttpServletRequest request, byte[] bytes) {
			Recipe recipe = createRecipe(request, bytes);
			recipe = recipeRepository.saveAndFlush(recipe);			
			return recipe;			
		}

		public Recipe readRecipe(Long id) {
			return (Recipe) recipeRepository.findOne(id);
		}

		public void deleteRecipe(Long id) {
			recipeRepository.delete(id);
		}	
			
		public List<Recipe> getAllRecipes() {
			List<Recipe> recipes = recipeRepository.findAll();
			return recipes;
		}
		
		
		
		public Recipe createRecipe(HttpServletRequest request, byte[] bytes) {
			
			Recipe recipe = new Recipe();
			List<Ingredient> listOfRecipeIngredients = new ArrayList<Ingredient>();
			List<RecipeComponent> listOfRecipeComponents = new ArrayList<RecipeComponent>();
			
			
			String recipeName = request.getParameter("recipeName");
			
			String[] arrayOfDescription = request.getParameter("recipeDescription").split("\n");
			ArrayList<String> recipeDescription = new ArrayList<String>(Arrays.asList(arrayOfDescription));
			
			FoodTag recipeTag = new FoodTag();
			recipeTag.setTagName(request.getParameter("recipeTag"));
						
			
			try{
				if(request.getParameter("recipeIngredientName1") != null) {
					listOfRecipeIngredients = getIngredientsFromRequest(request, "recipeIngredient");
				}
			}catch(Exception ex) {
				
			}
				
			
			for(int i = 1; i <= 3; i++) {
				if(request.getParameter("recipeComponentName" + i) != null) {
					RecipeComponent recipeComponent = getRecipeComponentFromRequest(request, i);
					System.out.println("component nr " + i + ": " + request.getParameter("recipeComponentName" + i));
					listOfRecipeComponents.add(recipeComponent);
				}else {
					break;
				}
			}
			
			
			recipe.setRecipeName(recipeName);
			recipe.setRecipeDescription(recipeDescription);
			recipe.setFoodTag(recipeTag);
			recipe.setRecipeIngredients(listOfRecipeIngredients);
			recipe.setRecipeComponents(listOfRecipeComponents);
			recipe.setPicture(bytes);
			
			return recipe;
		}


		
		
		
		
		
		private List<Ingredient> getIngredientsFromRequest(HttpServletRequest request, String parameter) {
			
			List<Ingredient> recipeIngredients = new ArrayList<Ingredient>();
			
			int counter = 1;
			boolean run = true;
			
			while(run) {	
			
				if(request.getParameter(parameter + "Name" + counter) == null) {
					run = false;
				}else {
				
				Ingredient recipeIngredient = new Ingredient();
				
				recipeIngredient.setIngredientName(request.getParameter(parameter + "Name" + counter));
				recipeIngredient.setAmountPerPortion(Double.parseDouble(request.getParameter(parameter + "Amount" + counter)));
				recipeIngredient.setUnitOfMeasurement(request.getParameter(parameter + "AmountUnit" + counter));
				FoodTag foodTag = new FoodTag();
				foodTag.setTagName(request.getParameter(parameter + "Tag" + counter));
				recipeIngredient.setFoodTag(foodTag);
				
				recipeIngredients.add(recipeIngredient);
				counter++;
				
				}
				
			}
			
			return recipeIngredients;
		}

		
		
		
		private RecipeComponent getRecipeComponentFromRequest(HttpServletRequest request, int componentNumber) {
			
			RecipeComponent recipeComponent = new RecipeComponent();
			
			List<Ingredient> listOfRecipeComponentIngredients = new ArrayList<Ingredient>();
			
			String recipeComponentName = request.getParameter("recipeComponentName" + componentNumber);
			String[] arrayOfDescription = request.getParameter("recipeComponentDescripton" + componentNumber).split("\n");
			ArrayList<String> recipeComponentDescription = new ArrayList<String>(Arrays.asList(arrayOfDescription));
			
		
			try{
				if(request.getParameter("component" + componentNumber + "IngredientName") != null) {
					listOfRecipeComponentIngredients = getIngredientsFromRequest(request, "component" + componentNumber + "Ingredient");
				}
			}catch(Exception ex) {
				
			}
					
			
			recipeComponent.setComponentName(recipeComponentName);
			recipeComponent.setComponentDescription(recipeComponentDescription);
			recipeComponent.setComponentIngredients(listOfRecipeComponentIngredients);
			
			
			return recipeComponent;
		}

		
	
		
		
}
