package com.pucrs.t1es2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucrs.t1es2.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByRegistration(String registration);
    List<Student> findByNameContaining(String name);
}
