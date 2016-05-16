package com.foodmood.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.foodmood.models.Recipe;
import com.foodmood.models.User;
import com.foodmood.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private ModelAndView modelAndView;
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response) {
		try {
			User user = userService.saveUser(request);		
			modelAndView= new ModelAndView("/viewUser.jsp");
			modelAndView.addObject("userLoggedIn", user);
			modelAndView.addObject("message", user.getName() + " added to database and logged on");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return modelAndView;
	}
	
	
	@RequestMapping(value="/loginUser")
	@ResponseBody
	public ModelAndView loginUser(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = null;
		//get user from session or whereever its stored
		try {
		    //User u = (User) request.getSession().getAttribute("userLoggedIn");
			//User currentUser = userService.getUser(id);
			//Long id = currentUser.getId();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println("user name & password from request: " + username + password);
			User user = userService.loginUser(null, username, password);

			modelAndView = new ModelAndView("/viewUser.jsp");
		if(user != null) {
			modelAndView.addObject("userLoggedIn", user);
			modelAndView.addObject("message", user.getName() + " logged on");
		}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return modelAndView;
	}
	
	
	@RequestMapping(value="/logoutUser", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView logoutUser(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		session.removeAttribute("userLoggedIn");
		ModelAndView modelAndView= new ModelAndView("/index.jsp");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value= "/userPage/{id:[\\d]+}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getUserPage(@PathVariable("id") Long id, HttpServletRequest request) {
		User userRequestedToShow = userService.getUser(id);	
		User userLoggedOn = (User) request.getSession().getAttribute("userLoggedIn");
		
		ModelAndView modelAndView = new ModelAndView("/viewUser.jsp");
		
		if(userRequestedToShow.getId().equals(userLoggedOn.getId())) {		//kolla att man bara kan komma åt sin egen sida
			if(userRequestedToShow != null) {
				modelAndView.addObject("userLoggedIn", userRequestedToShow);
			}	
		}
		return modelAndView;
	}
	
	
	
	//Fungerar inte ännu....
	@RequestMapping(value="/updateUser", method=RequestMethod.PUT)
	@ResponseBody
	public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response) {
		
		User userToFetchId = (User) request.getSession().getAttribute("userLoggedIn");
		Long id = userToFetchId.getId();
		
		User user = userService.updateUser(request, id);
		
		ModelAndView modelAndView= new ModelAndView("/viewUser.jsp");
		modelAndView.addObject("userLoggedIn", user);
		modelAndView.addObject("message", user.getName() + " updated and logged on");
		return modelAndView;
		
	}
	
	
	
	
	
	
}
