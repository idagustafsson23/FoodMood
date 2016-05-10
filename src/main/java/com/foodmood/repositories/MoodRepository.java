package com.foodmood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodmood.models.Mood;

public interface MoodRepository extends JpaRepository<Mood, Long> {

}
