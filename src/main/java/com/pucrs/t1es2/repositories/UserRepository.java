package com.pucrs.t1es2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucrs.t1es2.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
