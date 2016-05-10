package com.foodmood.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodmood.models.Recipe;
import com.foodmood.models.Wine;
import com.foodmood.repositories.WineRepository;

@Service
public class WineService {
	@Autowired
	private WineRepository wineRepository;

	public void saveWine(HttpServletRequest request) {
		Wine wine = createWine(request);
		wineRepository.saveAndFlush(wine);
		
	}

	public Wine readWine(Long id) {
		return (Wine) wineRepository.findOne(id);
	}

	public void deleteWine(Long id) {
		wineRepository.delete(id);
	}	
		
	public List<Wine> getAllWines() {
		List<Wine> wines = wineRepository.findAll();
		return wines;
	}
	
	
	public Wine createWine(HttpServletRequest request) {
		String wineSort = request.getParameter("wineSort");
		ArrayList<String> foodTags = getAllFoodTags();
		ArrayList<String> grapes = getAllGrapes(request);
		ArrayList<Integer> foodTagScores = getAllScores(request);
		
		Wine wine = new Wine();
		
		wine.setWineSort(wineSort);
		wine.setFoodTags(foodTags);
		wine.setGrapes(grapes);
		wine.setScoreForFoodTag(foodTagScores);		
		
		return wine;
	}
	
	public ArrayList<Integer> getAllScores(HttpServletRequest request){
		ArrayList<Integer> foodTagScores = new ArrayList<Integer>();
		
		for(int i = 1; i <= 35; i++){
			foodTagScores.add(Integer.parseInt(request.getParameter("score"+i)));
		}		
		
		return foodTagScores;
	}
	
	public ArrayList<String> getAllGrapes(HttpServletRequest request){
		ArrayList<String> grapes = new ArrayList<String>();
		int numberOfGrapes = Integer.parseInt(request.getParameter("numberOfGrapes"));
		for(int i = 1; i <= numberOfGrapes; i++){
			grapes.add(request.getParameter("grape"+i));
		}
		
		return grapes;
	}
	
	public ArrayList<String> getAllFoodTags(){
		ArrayList<String> foodTags = new ArrayList<String>();
		foodTags.add("Red Meat");
		foodTags.add("Cured Meat");
		foodTags.add("Pork");
		foodTags.add("Poultry");
		foodTags.add("Mollusk");
		foodTags.add("Fish");
		foodTags.add("Lobster and Shellfish");
		foodTags.add("Grilled or Barbecued");
		foodTags.add("Sautéed or Fried");
		foodTags.add("Smoked");
		foodTags.add("Roasted");
		foodTags.add("Poached or Steamed");
		foodTags.add("Soft cheese and Cream");
		foodTags.add("Pungent cheese");
		foodTags.add("Hard cheese");
		foodTags.add("Alliums");
		foodTags.add("Green vegetables");
		foodTags.add("Root vegetables and Squash");
		foodTags.add("Nightshades");
		foodTags.add("Funghi");
		foodTags.add("Nuts and Seeds");
		foodTags.add("Beans and Peas");
		foodTags.add("Black pepper");
		foodTags.add("Red pepper");
		foodTags.add("Hot and Spicy");
		foodTags.add("Herbs");
		foodTags.add("Baking spices");
		foodTags.add("Exotic and Aromatic spices");
		foodTags.add("White starches");
		foodTags.add("Whole wheat grains");
		foodTags.add("Sweet starchy vegetables");
		foodTags.add("Potato");
		foodTags.add("Fruit and Berries");
		foodTags.add("Vanilla and Caramel");
		foodTags.add("Chocolate and Coffee");
		
		return foodTags;
	}
	
	public Wine getMatchingWine(Recipe recipe){
		ArrayList<Wine> allWines = (ArrayList<Wine>) getAllWines();
		ArrayList<Integer> totalScoreForWines = new ArrayList<Integer>();
		
		for(int i = 0; i < allWines.size(); i++){
			totalScoreForWines.add(0);
			ArrayList<String> allFoodTags = allWines.get(i).getFoodTags();
			for(int a = 0; a < allFoodTags.size(); a++){
				if(allFoodTags.get(a).equals(recipe.getFoodTag().getTagName())){
					int score = allWines.get(i).getScoreForFoodTag().get(a);
					int oldScore = totalScoreForWines.get(i);
					totalScoreForWines.set(i, score + oldScore);
				}
				
				for(int b = 0; b < recipe.getRecipeIngredients().size(); b++){
					if(allFoodTags.get(a).equals(recipe.getRecipeIngredients().get(b).getFoodTag().getTagName())){
						int score = allWines.get(i).getScoreForFoodTag().get(a);
						int oldScore = totalScoreForWines.get(i);
						totalScoreForWines.set(i, score + oldScore);
					}
				}
				for(int b = 0; b < recipe.getRecipeComponents().size(); b++){
					for(int c = 0; c < recipe.getRecipeComponents().get(b).getComponentIngredients().size(); c++){
						String componentIngredientTag = recipe.getRecipeComponents().get(b).getComponentIngredients().get(c).getFoodTag().getTagName();
						if(allFoodTags.get(a).equals(componentIngredientTag)){
							int score = allWines.get(i).getScoreForFoodTag().get(a);
							int oldScore = totalScoreForWines.get(i);
							totalScoreForWines.set(i, score + oldScore);
						}
					}
				}
			}
			
		}
		
		int indexForTopScore = 0;
		for(int i = 0; i < totalScoreForWines.size(); i++){
			if(totalScoreForWines.get(i) > totalScoreForWines.get(indexForTopScore)){
				indexForTopScore = i;
			}
		}
		
		Wine wine = allWines.get(indexForTopScore);
		return wine;
	}
}
