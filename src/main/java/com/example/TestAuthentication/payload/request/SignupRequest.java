package com.example.TestAuthentication.payload.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class SignupRequest {
	@Size(max = 10)
	private int code;
	@NotBlank(message = "Username is not blank")
	@Size(min = 3, max = 20, message = "Username is not between 3 and 20 characters")
	private String username;
	@NotBlank(message = "Email is not blank")
	@Size(max = 50, message = "Email is not more than 50 characters")
	@Email(message = "Email is not valid")
	private String email;
	private boolean gender;
	@NotNull(message = "Birthday is not null")
	@Past(message = "Birthday is not valid")
	private LocalDate birthday;
	@NotBlank(message = "Phone is not blank")
	@Size(max = 10, message = "Phone is not more than 10 characters")
	private String phone;
	@Size(min = 8, max = 32, message = "Password is not between 8 and 32 characters")
	private String password;
	private Set<String> roles = new HashSet<>();
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
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
	
	public boolean isGender() {
		return gender;
	}
	
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	public LocalDate getBirthday() {
		return birthday;
	}
	
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<String> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
}