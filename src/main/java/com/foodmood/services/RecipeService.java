package com.foodmood.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodmood.models.Recipe;
import com.foodmood.repositories.RecipeRepository;

@Service
public class RecipeService {

		@Autowired
		private RecipeRepository recipeRepository;

		public Recipe saveRecipe(HttpServletRequest request) {
			Recipe recipe = createRecipe(request);
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
		
		
		public Recipe createRecipe(HttpServletRequest request) {
			String recipeName = request.getParameter("recipeName");
			String[] arrayOfDescription = request.getParameter("recipeDescription").split("\n");
			ArrayList<String> recipeDescription = new ArrayList<String>(Arrays.asList(arrayOfDescription));
			Recipe recipe = new Recipe();
			
			recipe.setRecipeName(recipeName);
			recipe.setRecipeDescription(recipeDescription);
			
			return recipe;
		}

		
		
}
