package com.foodmood.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.foodmood.models.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

	

}
