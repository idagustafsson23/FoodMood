package com.foodmood.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response) {
		
		User user = userService.saveUser(request);
		
		ModelAndView modelAndView= new ModelAndView("/viewUser.jsp");
		modelAndView.addObject("userLoggedIn", user);
		modelAndView.addObject("message", user.getName() + " added to database and logged on");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/loginUser", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView loginUser(HttpServletRequest request, HttpServletResponse response) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userService.loginUser(username, password);

		ModelAndView modelAndView= new ModelAndView("/viewUser.jsp");
		if(user != null) {
		modelAndView.addObject("userLoggedIn", user);
		modelAndView.addObject("message", user.getName() + " logged on");
		}
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="/logoutUser", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView logoutUser(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		session.removeAttribute("userLoggedIn");
		ModelAndView modelAndView= new ModelAndView("/index.jsp");
		return modelAndView;
	}
	
	
	
	
}
