package com.foodmood.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodmood.models.Mood;
import com.foodmood.repositories.MoodRepository;

@Service
public class MoodService {
	@Autowired
	private MoodRepository moodRepository;

	public void saveMood(HttpServletRequest request) {
		
		
	}

	public Mood readMood(Long id) {
		return (Mood) moodRepository.findOne(id);
	}

	public void deleteMood(Long id) {
		moodRepository.delete(id);
	}	
		
	public List<Mood> getAllMoods() {
		List<Mood> moods = moodRepository.findAll();
		return moods;
	}
}
