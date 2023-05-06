package com.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.recipes.entities.SignUpInfo;

@Repository
public interface SignUpRepository extends JpaRepository<SignUpInfo, Long>{

	//@Query("SELECT s FROM SignUpInfo s WHERE Username=?1")
	public SignUpInfo findByUsername(String username);
}
