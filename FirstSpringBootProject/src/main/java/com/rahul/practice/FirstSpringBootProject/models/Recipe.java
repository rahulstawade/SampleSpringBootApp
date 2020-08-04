package com.rahul.practice.FirstSpringBootProject.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Recipe")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String type;
	private String description;
	
//	@Transient
//	private boolean areIngredientsUpdated;

	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] image;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "recipe")
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();

	public void addIngredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
		ingredient.setRecipe(this);
	}

	public void removeIngredient(Ingredient ingredient) {
		this.ingredients.remove(ingredient);
		ingredient.setRecipe(null);
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
