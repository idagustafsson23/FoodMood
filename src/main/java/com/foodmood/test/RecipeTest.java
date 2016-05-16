package com.foodmood.test;

import static org.mockito.Mockito.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.foodmood.controllers.RecipeController;
import com.foodmood.models.Recipe;
import com.foodmood.services.RecipeService;



public class RecipeTest {
	

private static final Long id = 1L;	
	

@InjectMocks
private RecipeService recipeService;



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
    request.setParameter("recipeDescription", "hello1\nhello2");
    
    Recipe recipe = recipeService.createRecipe(request);
    Assert.assertEquals("testName", recipe.getRecipeName());
    Assert.assertEquals("hello1", recipe.getRecipeDescription().get(0));
    Assert.assertEquals("hello2", recipe.getRecipeDescription().get(1));
      
}

@Test
public void testSearchRecipeName() {
	MockHttpServletRequest httpRequest = new MockHttpServletRequest();
	httpRequest.setParameter("inputstring", "Skalman");
	RecipeController controller = new RecipeController();
	Assert.assertEquals("emptyinput: ", " ", controller.searchRecipe(httpRequest));	
}





}
