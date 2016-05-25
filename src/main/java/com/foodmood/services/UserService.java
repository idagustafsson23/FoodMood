package com.foodmood.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodmood.models.Recipe;
import com.foodmood.models.RecipeComponent;
import com.foodmood.models.User;
import com.foodmood.repositories.UserRepository;

@Service
@Transactional
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

	
	
	public void deleteUser(Long id) {
		userRepository.delete(id);
	}	
		
	
	
	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}
	
	
	@SuppressWarnings("null")
	public User loginUser(String username, String password) {
		List<User> users = userRepository.findAll();
		User user = null;
		for(User currentUser : users ) {
			System.out.println("username: " + currentUser.getUsername());
			if(currentUser.getUsername().equals(username) && currentUser.getPassword().equals(password)) {
				user = currentUser;
				System.out.println("found user");
				break;
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
		
		//detta gör alla users till icke-admin, fixa sen!!
		user.setAdmin(false);
		
		return user;
	}


	
	
	public User updateUser(HttpServletRequest request, Long id) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String phonenumber = request.getParameter("phonenumber");
		
		User user = readUser(id);
		
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		user.setAddress1(address1);
		user.setAddress2(address2);
		user.setPhoneNumber(phonenumber);
		
		userRepository.save(user);
		
		return user;
		
	}


	
	
	
	
	
}