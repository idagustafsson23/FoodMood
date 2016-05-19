
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
    byte[] by = new byte[1];
    
    
    request.setParameter("recipeName", "gryta");
    request.setParameter("recipeDescription", "desc-row1\ndesc-row2");
    
    request.setParameter("recipeIngredientName1", "kött");
    request.setParameter("recipeIngredientAmount1", "12");
    request.setParameter("recipeIngredientAmountUnit1", "dl");
    
    request.setParameter("recipeIngredientName2", "vatten");
    request.setParameter("recipeIngredientAmount2", "14");
    request.setParameter("recipeIngredientAmountUnit2", "l");
    
    request.setParameter("recipeTag", "meat");
    
    request.setParameter("recipeComponentName1", "comp1");
    request.setParameter("recipeComponentDescripton1", "desc-comp1-row1\ndesc-comp1-row2");
    
    request.setParameter("component1IngredientName", "comp1-ing1");
    request.setParameter("component1IngredientAmount", "12");
    request.setParameter("component1IngredientAmountUnit", "dl");
    
    request.setParameter("component1IngredientName", "comp1-ing2");
    request.setParameter("component1IngredientAmount", "14");
    request.setParameter("component1IngredientAmountUnit", "l");
    
    
    request.setParameter("recipeComponentName2", "");
    request.setParameter("recipeComponentDescripton2", "");
    
    
    
    Recipe recipe = recipeService.createRecipe(request, by);
    
    
    Assert.assertEquals("gryta", recipe.getRecipeName());
    Assert.assertEquals("desc-row1", recipe.getRecipeDescription().get(0));
    Assert.assertEquals("desc-row2", recipe.getRecipeDescription().get(1));
    Assert.assertEquals(null, recipe.getRecipeComponents().get(0));  
    Assert.assertEquals(null, recipe.getRecipeComponents().get(1));  
    
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
