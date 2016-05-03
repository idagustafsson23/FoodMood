package com.foodmood.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.foodmood.models.Recipe;

public interface UserRepository extends JpaRepository<Recipe, Long> {

	

}
