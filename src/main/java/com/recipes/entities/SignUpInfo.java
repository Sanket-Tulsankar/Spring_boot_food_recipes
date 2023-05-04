package com.recipes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_Id")
	private long id;
	
	@Column(name = "First_name")
	@NonNull
	private String fname;
	
	@Column(name = "Last_name")
	@NonNull
	private String lname;
	
	@Column(name = "Email")
	@NonNull
	private String email;
	
	@Column(name = "Username")
	@NonNull
	private String username;
	
	@Column(name = "Password")
	@NonNull
	private String password;
}
