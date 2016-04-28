package com.foodmood.test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.foodmood.controllers.RecipeController;
import com.foodmood.models.Recipe;
import com.foodmood.repositories.RecipeRepository;
import com.foodmood.services.RecipeService;

import org.junit.*;
import org.junit.Test;

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
    request.setParameter("recipeDescription", "testDescription");
    
    Recipe recipe = recipeController.createRecipe(request);
    Assert.assertEquals("testName", recipe.getRecipeName());
    Assert.assertEquals("testDescription", recipe.getRecipeDescription());
    
}



}
