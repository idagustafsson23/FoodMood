package com.foodmood.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foodmood.services.RecipeService;
import com.foodmood.services.WineService;

@Controller
@RequestMapping("/wine")
public class WineController {
	
	@Autowired
	private WineService wineService;
	
	
	@RequestMapping(value="/addWine", method=RequestMethod.POST)
	@ResponseBody
	public String addWine(HttpServletRequest request, HttpServletResponse response) {
		wineService.saveWine(request);
			
		return "Wine Added!";
	}

}
