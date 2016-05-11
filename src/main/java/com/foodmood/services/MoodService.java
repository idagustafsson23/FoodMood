package com.foodmood.services;

import java.util.ArrayList;
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
		Mood mood = creatMood(request);
		moodRepository.saveAndFlush(mood);
	}

	private Mood creatMood(HttpServletRequest request) {
		String moodType = request.getParameter("mood");
		ArrayList<String> grapes = getAllGrapes(request);
		
		Mood mood = new Mood();
		mood.setTheMood(moodType);
		mood.setGrapesForMood(grapes);
		
		
		return mood;
	}
	
	public ArrayList<String> getAllGrapes(HttpServletRequest request){
		ArrayList<String> grapes = new ArrayList<String>();
		int numberOfGrapes = Integer.parseInt(request.getParameter("numberOfGrapes"));
		for(int i = 1; i <= numberOfGrapes; i++){
			grapes.add(request.getParameter("grape"+i));
		}
		
		return grapes;
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
