package com.rahul.practice.FirstSpringBootProject.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.practice.FirstSpringBootProject.models.Ingredient;
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
		// return this.repo.saveAndFlush(newRecipeToAdd);

		List<Ingredient> ingredientsList = ingredientService.assigningRecipeToIngredients(newRecipeToAdd);
		newRecipeToAdd.setIngredients(ingredientsList);

		return this.repo.save(newRecipeToAdd);
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
	public Recipe updateRecipe(Recipe recipeforUpdate) {
		
		Recipe fetchedRecipe = this.repo.getOne(recipeforUpdate.getId());
		/* Recipe fetchedRecipe = this.repo.findById(recipeforUpdate.getId()).get(); */
		
		//Setting values for any changes in Recipe
		fetchedRecipe.setName(recipeforUpdate.getName());
		fetchedRecipe.setType(recipeforUpdate.getType());
		fetchedRecipe.setDescription(recipeforUpdate.getDescription());

		List<Ingredient> ingredientsList = ingredientService.assigningRecipeToIngredients(recipeforUpdate);

		
		//clearing old ingredients list tracked by hibernate
		fetchedRecipe.getIngredients().clear();
		//adding new ingredients to list tracked by hibernate
		fetchedRecipe.getIngredients().addAll(ingredientsList);
		
		
		//Below is Bad Approach : manually doing everything
		
		/*
		 * 1> Removing Ingredient from DB if not present in provided object for updation
		 */
		
		/*
		 * fetchedRecipe.getIngredients().removeIf((ingredient) -> { if
		 * (!recipeforUpdate.getIngredients().contains(ingredient)) {
		 * ingredient.setRecipe(null); return true; } return false; });
		 */

		//recipeforUpdate.getIngredients().forEach((ingredient) -> {
			
			/* 2> if new ingredient added */
			
			/*if (ingredient.getId() == 0) {
				fetchedRecipe.getIngredients().add(ingredient);
			}*/
			
			
			/* 3> if changes in existing ingredient */
			
			/*
			 * else { int index = fetchedRecipe.getIngredients().indexOf(ingredient); if
			 * (index != -1) { Ingredient storedIng =
			 * fetchedRecipe.getIngredients().get(index);
			 * storedIng.setName(ingredient.getName());
			 * storedIng.setQuantity(ingredient.getQuantity()); } }
			 */
			
			// 4> Setting Proper recipe object in Ingredient 
			// ingredient.setRecipe(fetchedRecipe);
		//});

		return this.repo.save(fetchedRecipe);

	}

	@Override
	public void deleteRecipeById(int recipeId) {
		this.repo.deleteById(recipeId);
	}

}
