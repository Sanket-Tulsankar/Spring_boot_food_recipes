package com.recipes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipes.entities.Recipes;
import com.recipes.exceptionHandler.NoRecipeFoundException;
import com.recipes.repository.RecipesRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipesRepository recipeRepository;
	
	@Override
	public Recipes addRecipes(Recipes recipes) {
		Recipes recipes2 = this.recipeRepository.save(recipes);
		return recipes2;
	}

	@Override
	public Recipes getSingleRecipes(String recipe_name) {
		Recipes findByRecipeName = this.recipeRepository.findByRecipeName(recipe_name);
		return findByRecipeName;
	}

	@Override
	public List<Recipes> getAllrecipes() throws NoRecipeFoundException {
		List<Recipes> list = this.recipeRepository.findAll();
		if(list.isEmpty()) {
			throw new NoRecipeFoundException("List is empty !!");
		}else {
			return list;
		}
	}

	@Override
	public String deleteRecipe(String recipe_name) {
		Recipes findByRecipeName = this.recipeRepository.findByRecipeName(recipe_name);
		long id=findByRecipeName.getRecipe_id();
		this.recipeRepository.deleteById(id);
	//	this.recipeRepository.deleteByRecipeName(recipe_name);
		return recipe_name +" deleted succesfully !!";
	}

	@Override
	public Recipes updateRecipe(Recipes recipes) {
		// TODO Auto-generated method stub
		return null;
	}

	// ------------------------------------------------------------------
	
//	public Recipes searchRecipes(String recipe_name) {
//		Recipes searchByRecipeName = this.recipeRepository.searchByRecipeName(recipe_name);
//		return searchByRecipeName;
//		}
	
}
