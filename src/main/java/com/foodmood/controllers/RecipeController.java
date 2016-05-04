package com.foodmood.controllers;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.core.dom.rewrite.NodeRewriteEvent;
import org.neo4j.collection.pool.MarshlandPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@RequestMapping(value="/addRecipe", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView addRecipe(HttpServletRequest request, HttpServletResponse response) {		
		Recipe recipe = recipeService.saveRecipe(request);
		ModelAndView modelAndView= new ModelAndView("/viewRecipe.jsp");
		modelAndView.addObject("recipe", recipe);
		return modelAndView;	
	}
		
	@RequestMapping(value= "/getRecipe/{id:[\\d]+}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getRecipe(@PathVariable("id") Long id) {
		Recipe recipe = recipeService.readRecipe(id);		
		ModelAndView modelAndView= new ModelAndView("/viewRecipe.jsp");
		modelAndView.addObject("recipe", recipe);
		return modelAndView;		
	}
	
	@RequestMapping(value = "/searchRecipe", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView searchRecipe(String searchData, Model model) {
		List<Recipe> recipeList = recipeService.getAllRecipes();
		ModelAndView recipeResult = new ModelAndView();
		if (recipeList != null && recipeList.size() > 0) {
			for (int r = 0; r < recipeList.size(); r++) {
				Recipe recipe = recipeList.get(r);
				if (recipe.getRecipeName().indexOf(searchData) > -1) {
				
				}
			}
		}
		return recipeResult;
	}
	
}
