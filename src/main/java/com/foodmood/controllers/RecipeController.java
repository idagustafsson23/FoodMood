package com.foodmood.controllers;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.core.dom.rewrite.NodeRewriteEvent;
import org.neo4j.collection.pool.MarshlandPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.foodmood.models.Recipe;
import com.foodmood.services.RecipeService;


@Controller
@RequestMapping("/recipe")
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	@ResponseBody
	public String index() {
		System.out.println("conny testing");
	   return "Testing Recipe!";
	}
	
	@RequestMapping(value = "/addRecipe", method=RequestMethod.POST)
	@ResponseBody
	public String addRecipe(HttpServletRequest request, HttpServletResponse response) {		
		recipeService.saveRecipe(createRecipe(request));
		ModelAndView modelAndView = new ModelAndView();		
		return "Recipe Added!";
	}
	
	
	public Recipe createRecipe(HttpServletRequest request) {
		String recipeName = request.getParameter("recipeName");
		String recipeDescription = request.getParameter("recipeDescription");
		Recipe recipe = new Recipe();
		recipe.setRecipeName(recipeName);
		return recipe;
	}
	
	
}
