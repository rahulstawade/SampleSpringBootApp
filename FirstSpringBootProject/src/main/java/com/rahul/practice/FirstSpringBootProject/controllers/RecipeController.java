package com.rahul.practice.FirstSpringBootProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.practice.FirstSpringBootProject.models.Recipe;
import com.rahul.practice.FirstSpringBootProject.services.IRecipeService;

@RestController
@RequestMapping("api/recipe")
public class RecipeController {

	@Autowired
	private IRecipeService recipeService;

	public IRecipeService getRecipeService() {
		return recipeService;
	}

	public void setRecipeService(IRecipeService recipeService) {
		this.recipeService = recipeService;
	}

	// post OR create
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Recipe addRecipe(@RequestBody final Recipe newRecipe) {
		return this.getRecipeService().addNewRecipe(newRecipe);
	}

	
	// get or read

	@GetMapping("/getAllRecipies")
	public List<Recipe> fetchAllRecipies() {
		return this.getRecipeService().fetchAllRecipies();
	}

	@GetMapping("/getRecipe/{id}")
	public Recipe fetchRecipieById(@PathVariable int id) {
		return this.getRecipeService().getRecipeById(id);
	}

	// put or update

	@PutMapping("/update")
	public Recipe updateRecipe(@RequestBody final Recipe newRecipe) {
		return this.getRecipeService().updateRecipe(newRecipe);
	}

	// delete

	@DeleteMapping("/delete/{id}")
	public void deleteRecipieById(@PathVariable int id) {
		this.getRecipeService().deleteRecipeById(id);
	}
	
	
	
	@GetMapping("/print")
	public String letsPrint() {
		return getRecipeService().print();
	}

}
