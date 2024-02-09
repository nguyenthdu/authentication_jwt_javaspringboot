package com.example.TestAuthentication.repository;

import com.example.TestAuthentication.models.ERole;
import com.example.TestAuthentication.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}