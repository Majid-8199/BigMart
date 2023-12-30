package com.example.demo.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;

@Entity
@Table(name="users")
public class User {
@Id
@GeneratedValue()
private int id;
@NotBlank(message = "Username is required")
private String username;
@Email(message = "Invalid email address")
@Column(unique=true)
private String email;
@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message = "Password length must be 8 and contain at least 1 uppercase,lowercase & digit")
private String password;

public User() {
	super();
}

public User(int id, String username, String email, String password) {
	super();
	this.id = id;
	this.username = username;
	this.email = email;
	this.password = password;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + "]";
}
}