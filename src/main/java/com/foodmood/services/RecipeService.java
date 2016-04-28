package com.foodmood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodmood.models.Recipe;
import com.foodmood.repositories.RecipeRepository;

@Service
public class RecipeService {

		@Autowired
		private RecipeRepository recipeRepository;

		public void saveRecipe(Recipe recipe) {
			recipeRepository.saveAndFlush(recipe);
		}

		public Recipe readRecipe(Long id) {
			return (Recipe) recipeRepository.getOne(id);
		}

		public void deleteRecipe(Long id) {
			recipeRepository.delete(id);
		}	
			
		public List<Recipe> getAllRecipes() {
			List<Recipe> recipes = recipeRepository.findAll();
			return recipes;
		}
}
