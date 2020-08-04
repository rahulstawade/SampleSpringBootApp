package com.rahul.practice.FirstSpringBootProject.services;

import java.util.List;

import com.rahul.practice.FirstSpringBootProject.models.Ingredient;
import com.rahul.practice.FirstSpringBootProject.models.Recipe;

public interface IIngredientService {

	
	public List<Ingredient> assigningRecipeToIngredients(Recipe newRecipeToAdd);
}
