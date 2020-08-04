package com.rahul.practice.FirstSpringBootProject.services;

import java.util.List;

import com.rahul.practice.FirstSpringBootProject.models.Recipe;

public interface IRecipeService {

	public String print();

	public Recipe addNewRecipe(Recipe newRecipeToAdd);

	public List<Recipe> fetchAllRecipies();

	public Recipe getRecipeById(int recipeId);

	public Recipe updateRecipe(Recipe recipeToUpdate);

	public void deleteRecipeById(int recipeId);

}
