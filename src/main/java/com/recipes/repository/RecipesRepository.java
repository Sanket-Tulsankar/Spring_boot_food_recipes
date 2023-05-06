package com.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recipes.entities.Recipes;

@Repository
public interface RecipesRepository extends JpaRepository<Recipes, Long>{

	public Recipes findByRecipeName(String recipe_name);
	
//	@Query("SELECT r from recipes r WHERE r.recipe_name LIKE %:name%")
//	public Recipes searchByRecipeName(@Param("name") String name);
	
}
