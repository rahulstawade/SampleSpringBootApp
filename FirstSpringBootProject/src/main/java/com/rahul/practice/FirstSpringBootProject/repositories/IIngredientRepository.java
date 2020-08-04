package com.rahul.practice.FirstSpringBootProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.practice.FirstSpringBootProject.models.Ingredient;

@Repository
public interface IIngredientRepository extends JpaRepository<Ingredient, Integer> {

}
