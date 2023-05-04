package com.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipes.entities.SignUpInfo;

@Repository
public interface SignUpRepository extends JpaRepository<SignUpInfo, Long>{

}
