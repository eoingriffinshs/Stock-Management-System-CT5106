package com.ct5106.StockManagementSystem.domain;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class AppUser
{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(nullable = false, updatable = false)
private Long id;
@Column(nullable = false, unique = true)
private String username;
@Column(nullable = false)
private String password;
@Column(nullable = false)
private String role;
public AppUser()
{
}
public AppUser(String username, String password, String role)
{
super();
this.username = username;
this.password = password;
this.role = role;
}

public String getPassword() {
	// TODO Auto-generated method stub
	return password;
}
public String getRole() {
	// TODO Auto-generated method stub
	return role;
}
}
