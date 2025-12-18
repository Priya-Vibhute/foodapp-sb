package com.learn.foodapp.entities;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.learn.foodapp.controllers.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements UserDetails {
	
	@GeneratedValue(strategy = GenerationType.UUID)
	@Id
	private String id;
	
	private String name;
	
	private String password;
	
	@Column(unique = true)
	private String email;
	
	private int age;
	
	@OneToOne(mappedBy ="user",cascade = CascadeType.ALL )
	@JsonBackReference
	private Cart cart;
	
	
	@ManyToOne
	@JsonManagedReference
	private Role role;
	
	@OneToMany(mappedBy = "user")
	@JsonBackReference
	private List<Order> orders;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		
		return Arrays.asList(new SimpleGrantedAuthority(role.getRoleName().toString()));
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	
	@Override
	 public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public  boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
}
