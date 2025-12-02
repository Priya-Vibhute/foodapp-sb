package com.learn.foodapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.foodapp.controllers.Role;
import com.learn.foodapp.entities.AppRole;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
       Optional<Role>	findByRoleName(AppRole appRole);

}
