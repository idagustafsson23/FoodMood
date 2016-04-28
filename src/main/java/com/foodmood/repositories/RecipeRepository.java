package com.foodmood.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.foodmood.models.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

	
	

}
