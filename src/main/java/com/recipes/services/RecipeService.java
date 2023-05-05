package com.recipes.services;

import java.util.List;

import com.recipes.entities.Recipes;
import com.recipes.exceptionHandler.NoRecipeFoundException;

public interface RecipeService {

	public Recipes addRecipes(Recipes recipes);
	
	public Recipes getSingleRecipes(String recipe_name);
	
	public List<Recipes> getAllrecipes() throws NoRecipeFoundException ;
	
	public String deleteRecipe(String recipe_name);
	
	public Recipes updateRecipe(Recipes recipes);
}
