package com.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipes.entities.Recipes;

@Repository
public interface RecipesRepository extends JpaRepository<Recipes, Long>{

	public Recipes findByRecipeName(String recipe_name);
	
}
