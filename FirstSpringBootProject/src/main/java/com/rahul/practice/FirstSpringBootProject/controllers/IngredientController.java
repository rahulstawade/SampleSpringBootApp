package com.rahul.practice.FirstSpringBootProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.practice.FirstSpringBootProject.services.IIngredientService;

@RestController
@RequestMapping("api/ingredient")
public class IngredientController {
	
	@Autowired
	private IIngredientService ingredientService;

	public IIngredientService getIngredientService() {
		return ingredientService;
	}

	
	//create [post]
	
	//read [get]
	
	
	//update[put]
	
	
	//delete[delete]
	
	

}
