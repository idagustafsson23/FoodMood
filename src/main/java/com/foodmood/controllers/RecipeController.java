package com.foodmood.controllers;

import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jdt.internal.core.dom.rewrite.NodeRewriteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foodmood.models.Recipe;
import com.foodmood.repositories.RecipeRepository;


@Controller
@RequestMapping("/recipe")
public class RecipeController {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	@ResponseBody
	public String index() {
		System.out.println("conny testing");
	   return "Testing Recipe!";
	}
	
	@RequestMapping(value = "/regRecipe", method=RequestMethod.POST)
	@ResponseBody
	public String regRecipe(HttpServletRequest request) {
		String recipeName = request.getParameter("recipeName");
		String recipeDescription = request.getParameter("recipeDescription");
		Recipe recipe = new Recipe();
		recipe.setRecipeName(recipeName);
		recipe.setRecipeDescription(recipeDescription);
		recipeRepository.saveAndFlush(recipe);
		return "Testing add Recipe!";
	}
	
	
}
