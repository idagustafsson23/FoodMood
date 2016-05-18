package com.foodmood.test;

import static org.mockito.Mockito.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;
import org.junit.runner.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.foodmood.Application;
import com.foodmood.controllers.RecipeController;
import com.foodmood.models.Recipe;
import com.foodmood.repositories.RecipeRepository;
import com.foodmood.services.RecipeService;


public class RecipeTest {
		

@InjectMocks
private RecipeService recipeService;

@Autowired
private RecipeService otherService;




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
    
    
    request.setParameter("recipeName", "skalman");
    request.setParameter("recipeDescription", "hello1\nhello2");
    request.setParameter("recipeIngredientName", "Superman");
    request.setParameter("recipeIngredientAmount", "20");
    
    Recipe recipe = recipeService.createRecipe(request);
    Assert.assertEquals("skalman", recipe.getRecipeName());
    Assert.assertEquals("hello1", recipe.getRecipeDescription().get(0));
    Assert.assertEquals("hello2", recipe.getRecipeDescription().get(1));
      
}

/*
@Test
public void testSearchEmptyInput() {
	MockHttpServletRequest httpRequest = new MockHttpServletRequest();
	httpRequest.setParameter("inputstring", "Skalman");	
	Recipe recipe = otherService.searchRecipe(httpRequest);
	Assert.assertEquals(" ", recipe.getRecipeName());	
} */


@Test 
public void testSearchRecipeName() {
	
}


}
