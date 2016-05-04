package com.foodmood.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.foodmood.models.User;
import com.foodmood.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/addRecipe", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView addRecipe(HttpServletRequest request, HttpServletResponse response) {
		
		User user = userService.saveUser(request);
		
		ModelAndView modelAndView= new ModelAndView("/viewUser.jsp");
		modelAndView.addObject("user", user);
		return modelAndView;
		
		
	}
	
	
	
	
}
