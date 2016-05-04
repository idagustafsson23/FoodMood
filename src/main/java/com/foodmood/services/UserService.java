package com.foodmood.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodmood.models.Recipe;
import com.foodmood.models.RecipeComponent;
import com.foodmood.models.User;
import com.foodmood.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public UserService() {
		
	}


	public User saveUser(HttpServletRequest request) {
		User user = createUser(request);
		user = userRepository.saveAndFlush(user);
		return user;
	}
	

	public User readUser(Long id) {
		return (User) userRepository.findOne(id);
	}

	
	
	public void deleteRecipe(Long id) {
		userRepository.delete(id);
	}	
		
	
	
	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}
	
	
	public User loginUser(String username, String password) {
		List<User> users = userRepository.findAll();
		User user = null;
		for(User currentUser : users ) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				user = currentUser;
			}
		}
		return user;
	}
	
	private User createUser(HttpServletRequest request) {
		String username = request.getParameter("registerUsername");
		String password = request.getParameter("registerPassword");
		String name = request.getParameter("registerName");
		String email = request.getParameter("registerEmail");
		String address1 = request.getParameter("registerAddress1");
		String address2 = request.getParameter("registerAddress2");
		String phonenumber = request.getParameter("registerPhonenumber");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		user.setAddress1(address1);
		user.setAddress2(address2);
		user.setPhoneNumber(phonenumber);
		
		//detta gör alla users till admin, fixa sen!!
		user.setAdmin(true);
		
		return user;
	}


	
	
}
