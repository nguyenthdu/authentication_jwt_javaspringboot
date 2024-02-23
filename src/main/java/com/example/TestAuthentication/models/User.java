package com.example.TestAuthentication.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "username"), @UniqueConstraint(columnNames = "email")})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
	@NotBlank(message = "Password is not blank")
	@Size(min = 8, max = 32, message = "Password is not between 8 and 32 characters")
	private String password;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	private boolean status = true;
	@Column(name = "created_date")
	private LocalDate createdDate = LocalDate.now();
	
	public User() {
	}
	
	public User(int code, String username, String email, boolean gender, LocalDate birthday, String phone, String password) {
		this.code = code;
		this.username = username;
		this.email = email;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
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
	
	public Set<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	
	@Override
	public String toString() {
		return "User{" + "id=" + id + ", code=" + code + ", username='" + username + '\'' + ", email='" + email + '\'' + ", gender=" + gender + ", birthday=" + birthday + ", phone='" + phone + '\'' + ", password='" + password + '\'' + ", roles=" + roles + ", status=" + status + ", createdDate=" + createdDate + '}';
	}
}