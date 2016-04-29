package com.foodmood.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.foodmood.controllers.RecipeController;
import com.foodmood.models.Recipe;

public class MockTest {
	

private static final Long id = 1L;	
	

@InjectMocks
private RecipeController recipeController;



@Before
public void init() {
	MockitoAnnotations.initMocks(this);
}



@Test
public void testInputRecipe() {
	MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    request.addHeader(HttpHeaders.HOST, "myhost.com");
    request.setLocalPort(8081);
    request.setRemoteAddr("127.0.0.1"); 
    
    request.setParameter("recipeName", "testName");
    
    
    Recipe recipe = recipeController.createRecipe(request);
    Assert.assertEquals("testName", recipe.getRecipeName());
   
    
}



}
