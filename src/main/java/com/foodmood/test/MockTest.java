package com.foodmood.test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import com.foodmood.repositories.RecipeRepository;
import com.foodmood.services.RecipeService;

import org.junit.*;
import org.junit.Test;

public class MockTest {

private static final Long id = 1L;	
	
@InjectMocks
private RecipeService recipeService;

@Mock
private RecipeRepository recipeDAO;

@Before
public void init() {
	
	MockitoAnnotations.initMocks(this);
}

@Test
public void testCreateRecipe()  {
    String recipeName = "Meatgrinder";
    String recipeDesc = "MinceMeat";
    
}



@Test
public void testReadRecipe()  {
    String recipeName = recipeService.readRecipe(id).getRecipeName();
    String recipeDesc = recipeService.readRecipe(id).getRecipeDescription();
    Assert.assertEquals("Meatgrinder", recipeName);
    Assert.assertEquals("MinceMeat", recipeDesc);
}

}
