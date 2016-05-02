package com.foodmood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodmood.models.Wine;

public interface WineRepository extends JpaRepository<Wine, Long> {

}
