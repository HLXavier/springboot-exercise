package com.pucrs.t1es2.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucrs.t1es2.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
