package com.foodmood.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.secure.spi.GrantedPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.foodmood.api.APIManager;
import com.foodmood.models.ApiWine;
import com.foodmood.models.Mood;
import com.foodmood.models.Recipe;
import com.foodmood.models.Wine;
import com.foodmood.services.MoodService;
import com.foodmood.services.RecipeService;
import com.foodmood.services.WineService;

@Controller
@RequestMapping("/wine")
public class WineController {
	
	@Autowired
	private WineService wineService;
	@Autowired
	private RecipeService recipeService;
	@Autowired
	private MoodService moodService;
	
	private APIManager apiManager = new APIManager();
	
	@RequestMapping(value="/addWine", method=RequestMethod.POST)
	@ResponseBody
	public String addWine(HttpServletRequest request, HttpServletResponse response) {
		wineService.saveWine(request);
			
		return "Wine Added!";
	}
	
	@RequestMapping(value="/getWine", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getWine(HttpServletRequest request, HttpServletResponse response) {
		Long recipeId = Long.parseLong(request.getParameter("recipeId"));
		Recipe recipe = recipeService.readRecipe(recipeId);
		Wine wine = wineService.getMatchingWine(recipe);
		
		for(String grape : wine.getGrapes()) {
			System.out.println(wine.getWineSort() + " grape: " + grape);
		}
		
		String usersMood = request.getParameter("mood");
		System.out.println(usersMood);
		ArrayList<Mood> allMoods = (ArrayList<Mood>) moodService.getAllMoods();
		ArrayList<String> grapesOfMood = new ArrayList<String>();
		for(Mood mood : allMoods){
			if(mood.getTheMood().equals(usersMood)){
				grapesOfMood = mood.getGrapesForMood();
			}
		}
		ArrayList<String> grapesOfWine = wine.getGrapes();
		String theGrapeToUse = null;
		for(String wineGrape : grapesOfWine){
			for(String moodGrape : grapesOfMood){
				if(wineGrape.equals(moodGrape)){
					theGrapeToUse = moodGrape;
				}
			}
		}
		String priceRange = request.getParameter("winePrice");
		String[] priceArray = priceRange.split("-");
		double minPrice = Double.parseDouble(priceArray[0]);
		double maxPrice = Double.parseDouble(priceArray[1]);
		
		
		apiManager.initializeConnection();
		ArrayList<ApiWine> listOfMatchingWines = apiManager.getMatchingWines(20, theGrapeToUse, minPrice, maxPrice);
		
		
		System.out.println("Vin sort: " + wine.getWineSort());
		System.out.println("MinPrice: " + minPrice );
		System.out.println("MaxPrice: " + maxPrice);
		System.out.println("Druva: " + theGrapeToUse);
		
		
		ModelAndView modelAndView = new ModelAndView("/results.jsp");
		modelAndView.addObject("recipe", recipe);
		modelAndView.addObject("apiWines", listOfMatchingWines);
		return modelAndView;
	}

}
