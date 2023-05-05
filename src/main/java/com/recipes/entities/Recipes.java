package com.recipes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long recipe_id;
	
	@Column(name = "Recipe_name")
	private String recipeName;
	
	@Lob
	@Column(name = "Ingredients" ,length = 5000)
	private String ingredients;

	@Lob
	@Column(name = "Direction" , length = 500000)
	private String direction;
	
	@Column(name = "Veg_NonVeg")
	private VegNonVeg vegNonVeg;
	
	@Column(name = "Type_of_Food")
	private Types type;
	
}
