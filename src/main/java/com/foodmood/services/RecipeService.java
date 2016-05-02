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

		public void saveRecipe(HttpServletRequest request) {
			Recipe recipe = createRecipe(request);
			recipeRepository.saveAndFlush(recipe);
			
			Recipe recipe2 = readRecipe(2L);
			System.out.println("antal i array" + recipe2.getRecipeDescription().size());
			for(String string : recipe2.getRecipeDescription()) {
				System.out.println(string);
			}
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
			System.out.println("descr:" + request.getParameter("recipeDescription"));
			String[] arrayOfDescription = request.getParameter("recipeDescription").split("\n");
			ArrayList<String> recipeDescription = new ArrayList<String>(Arrays.asList(arrayOfDescription));
			Recipe recipe = new Recipe();
			
			recipe.setRecipeName(recipeName);
			recipe.setRecipeDescription(recipeDescription);
			
			return recipe;
		}

		
		
}
