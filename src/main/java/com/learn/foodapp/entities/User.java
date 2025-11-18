package com.learn.foodapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	
	@GeneratedValue(strategy = GenerationType.UUID)
	@Id
	private String id;
	
	private String name;
	
	private String password;
	
	@Column(unique = true)
	private String email;
	
	private int age;
	
	@OneToOne(mappedBy ="user" )
	private Cart cart;
	
}
