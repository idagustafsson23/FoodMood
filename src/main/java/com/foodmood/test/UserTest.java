
package com.foodmood.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;

import com.foodmood.services.UserService;

public class UserTest {
		
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@InjectMocks
	private UserService userService;
	
	@Test
	public void testUserRegistration() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setParameter("registerUserName", "Leo");
		request.setParameter("registerPassword", "testing");
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
	}
	
	@Test 
	public void testUserLogin() {
		
	}

}

