package com.foodmood.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodmood.models.User;
import com.foodmood.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public UserService() {
		
	}


	public User saveUser(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
