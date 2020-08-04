package com.rahul.practice.FirstSpringBootProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.practice.FirstSpringBootProject.models.Ingredient;
import com.rahul.practice.FirstSpringBootProject.models.Recipe;
import com.rahul.practice.FirstSpringBootProject.repositories.IIngredientRepository;

@Service("ingredientService")
public class IngredientServiceImpl implements IIngredientService {

	@Autowired
	private IIngredientRepository repo;

	@Override
	public Recipe assigningRecipeToIngredients(Recipe newRecipeToAdd) {
		// return this.repo.saveAndFlush(newRecipeToAdd);

		// setting up recipe_id for ingredients if any
		newRecipeToAdd.getIngredients().forEach((ingredient) -> {
			ingredient.setRecipe(newRecipeToAdd);
		});

		return newRecipeToAdd;
	}
	
	
	
	public Recipe updateIngredientsInsideRecipe(Recipe recipeToUpdate,List<Ingredient> ingredentsList) {
		
		return null;
		
	}
}
