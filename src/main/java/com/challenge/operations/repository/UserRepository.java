package com.challenge.operations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.challenge.operations.entity.User;

import java.util.Optional;

/**
 * UserRepository is a JPA repository interface for managing User entities.
 * It provides CRUD operations as well as a method to find a User by their username.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
