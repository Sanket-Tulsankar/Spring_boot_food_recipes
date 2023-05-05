package com.recipes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipes.entities.Recipes;
import com.recipes.exceptionHandler.NoRecipeFoundException;
import com.recipes.services.RecipeService;

@RestController
@RequestMapping("/recipes")
@CrossOrigin
public class RecipesController {

	@Autowired
	private RecipeService recipeService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addRecipe(@RequestBody Recipes recipe){
		Recipes addRecipes = this.recipeService.addRecipes(recipe);
		return new ResponseEntity<Recipes>(addRecipes,HttpStatus.CREATED);
	}
	
	@GetMapping("get/{recipe_name}")
	public ResponseEntity<?> getRecipe(@PathVariable String recipe_name){
		Recipes singleRecipes = this.recipeService.getSingleRecipes(recipe_name);
		return new ResponseEntity<Recipes>(singleRecipes,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllRecipes() throws NoRecipeFoundException{
		List<Recipes> allrecipes = this.recipeService.getAllrecipes();
		return new ResponseEntity<List<Recipes>>(allrecipes,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{recipe_name}")
	public ResponseEntity<?> deleteRecipe(@PathVariable String recipe_name){
		String deleteRecipe = this.recipeService.deleteRecipe(recipe_name);
		return new ResponseEntity<String>(deleteRecipe,HttpStatus.OK);
	}
}
