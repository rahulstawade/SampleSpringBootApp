package com.rahul.practice.FirstSpringBootProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.practice.FirstSpringBootProject.models.Recipe;
import com.rahul.practice.FirstSpringBootProject.repositories.IRecipeRepository;

@Service("recipeService")
public class RecipeServiceImpl implements IRecipeService {

	@Autowired
	IRecipeRepository repo;
	
	@Autowired
	IIngredientService ingredientService;

	@Override
	public String print() {
		return "Printing....";
	}

	@Override
	@Transactional
	public Recipe addNewRecipe(Recipe newRecipeToAdd) {
		//return this.repo.saveAndFlush(newRecipeToAdd);
		
		// setting up recipe_id for ingredients if any	
		
//		newRecipeToAdd.getIngredients().forEach((ingredient)->{
//			ingredient.setRecipe(newRecipeToAdd);
//		});
		
		Recipe recipeToSave =ingredientService.assigningRecipeToIngredients(newRecipeToAdd);
		
		
		return this.repo.save(recipeToSave);
	}

	@Override
	public List<Recipe> fetchAllRecipies() {
		return this.repo.findAll();
	}

	@Override
	public Recipe getRecipeById(int recipeId) {
		return this.repo.getOne(recipeId);
	}

	@Override
	public Recipe updateRecipe(Recipe recipeToUpdate) {
		Recipe fetchedRecipe = this.repo.getOne(recipeToUpdate.getId());
		
		//Recipe fetchedRecipe = this.repo.findById(recipeToUpdate.getId());
		fetchedRecipe.getDescription();
		
		fetchedRecipe.setName(recipeToUpdate.getName());
		fetchedRecipe.setType(recipeToUpdate.getType());
		fetchedRecipe.setDescription(recipeToUpdate.getDescription());
		
		Recipe updatedRecipe = ingredientService.assigningRecipeToIngredients(recipeToUpdate);
		
//		recipeToUpdate.getIngredients().forEach((ingredient) -> {
//			if(ingredient.getId()==0) {
//				ingredient.setRecipe(fetchedRecipe);
//			}
//		});
		
		fetchedRecipe.setIngredients(updatedRecipe.getIngredients());		
		

		return this.repo.save(fetchedRecipe);
	}
	
	@Override
	public void deleteRecipeById(int recipeId) {		
		this.repo.deleteById(recipeId);		
	}
	
	
}
