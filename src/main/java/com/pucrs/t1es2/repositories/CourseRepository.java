package com.pucrs.t1es2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucrs.t1es2.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course findByCodeAndCourseClass(String code, Integer courseClass);
}
