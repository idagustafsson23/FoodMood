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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodmood.api.APIManager;
import com.foodmood.models.Ingredient;
import com.foodmood.models.Recipe;
import com.foodmood.services.RecipeService;


@Controller
@RequestMapping("/recipe")
public class RecipeController {
	
	private ModelAndView modelAndView;
	
	@Autowired
	private RecipeService recipeService;
	
	
	@RequestMapping(value="/addRecipe", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView addRecipe(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {	
		byte[] bytes = file.getBytes();
		Recipe recipe = recipeService.saveRecipe(request, bytes);
		
		ModelAndView modelAndView= new ModelAndView("/viewRecipe.jsp");
		modelAndView.addObject("recipe", recipe);
		return modelAndView;	
	}
		
	@RequestMapping(value= "/getRecipe/{id:[\\d]+}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getRecipe(@PathVariable("id") Long id) {
		Recipe recipe = recipeService.readRecipe(id);		
		ModelAndView modelAndView = new ModelAndView("/viewRecipe.jsp");
		modelAndView.addObject("recipe", recipe);
		return modelAndView;		
	}
	
	@RequestMapping(value = "/getAllRecipes", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getAllRecipes() {
		List<Recipe> allRecipes = recipeService.getAllRecipes();
		
		ModelAndView modelAndView = new ModelAndView("/viewRecipes.jsp");
		modelAndView.addObject("listOfRecipes", allRecipes);
		return modelAndView;
		
	}
	


	@RequestMapping(value = "/searchrecipe", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView searchRecipe(HttpServletRequest request) {
		Recipe recipe = null;	
		//List<Recipe> recipeList = recipeService.getAllRecipes();	
		try {
			Recipe recipeResult = recipeService.searchRecipe(request);
			modelAndView = new ModelAndView("/searchrecipe.jsp");
			if (recipeResult != null) {		
				modelAndView.addObject("recipename", recipeResult.getRecipeName());
			} else {
				modelAndView.addObject("recipename", " ");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return modelAndView;
	}
	
}
