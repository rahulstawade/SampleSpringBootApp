package com.rahul.practice.FirstSpringBootProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.practice.FirstSpringBootProject.models.Recipe;

/*SpringBoot upfrontly KNOWS and CREATE a Bean for any Interface extending
 *  JpaRepository Interface but we can also add @Repository annotation if we want*/
@Repository
public interface IRecipeRepository extends JpaRepository<Recipe, Integer> {
}
