package com.foodmood.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodmood.models.FoodTag;
import com.foodmood.models.Ingredient;
import com.foodmood.models.Recipe;
import com.foodmood.models.RecipeComponent;
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
			
			ArrayList<RecipeComponent> recipeComponents = getRecipeComponents(request);
			
						
			List<Ingredient> recipeIngredients = getRecipeIngredients(request);
			
			
			FoodTag recipeTag = new FoodTag();
			recipeTag.setTagName(request.getParameter("recipeTag"));
						
			Recipe recipe = new Recipe();
			
			recipe.setRecipeName(recipeName);
			recipe.setRecipeDescription(recipeDescription);
			recipe.setFoodTag(recipeTag);
			recipe.setRecipeComponents(recipeComponents);
			recipe.setRecipeIngredients(recipeIngredients);
	
			
			return recipe;
		}

		private List<Ingredient> getRecipeIngredients(HttpServletRequest request) {
			List<Ingredient> recipeIngredients = new ArrayList<Ingredient>();
			Ingredient recipeIngredient = new Ingredient();
			recipeIngredient.setIngredientName(request.getParameter("recipeIngredientName"));
			recipeIngredient.setAmountPerPortion(Double.parseDouble(request.getParameter("recipeIngredientAmount")));
			recipeIngredient.setUnitOfMeasurement(request.getParameter("recipeAmountUnit"));
			
			FoodTag recipeIngredientfoodTag = new FoodTag();
			recipeIngredientfoodTag.setTagName(request.getParameter("recipeIngredientTags"));
			
			recipeIngredient.setFoodTag(recipeIngredientfoodTag);
			
			recipeIngredients.add(recipeIngredient);
			return recipeIngredients;
		}

		private ArrayList<RecipeComponent> getRecipeComponents(HttpServletRequest request) {
			ArrayList<RecipeComponent> recipeComponents = new ArrayList<RecipeComponent>();
			RecipeComponent recipeComponent = new RecipeComponent();
			recipeComponent.setComponentName(request.getParameter("recipeComponentName"));
			
			String[] arrayOfComponentDescription = request.getParameter("recipeComponentDescripton").split("\n");
			recipeComponent.setComponentDescription(new ArrayList<String>(Arrays.asList(arrayOfComponentDescription)));
			
			recipeComponent.setComponentIngredients(getRecipeComponentIngredients(request));
			recipeComponents.add(recipeComponent);
			return recipeComponents;
		}

		private List<Ingredient> getRecipeComponentIngredients(HttpServletRequest request) {
			List<Ingredient> recipeComponentIngrediens = new ArrayList<Ingredient>();
			Ingredient ingredient = new Ingredient();
			ingredient.setIngredientName(request.getParameter("componentIngredientName"));
			ingredient.setAmountPerPortion(Double.parseDouble(request.getParameter("componentIngredientAmount")));
			ingredient.setUnitOfMeasurement(request.getParameter("componentAmountUnit"));
			
			FoodTag foodTag = new FoodTag();
			foodTag.setTagName(request.getParameter("componentIngredientTags"));
			
			ingredient.setFoodTag(foodTag);
			recipeComponentIngrediens.add(ingredient);
			return recipeComponentIngrediens;
		}
		
		
}
