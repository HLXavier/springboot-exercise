package com.pucrs.t1es2.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pucrs.t1es2.dtos.requests.CreateCourseDto;
import com.pucrs.t1es2.dtos.responses.FindStudentDto;
import com.pucrs.t1es2.entities.Course;
import com.pucrs.t1es2.mappers.CourseMapper;
import com.pucrs.t1es2.mappers.StudentMapper;
import com.pucrs.t1es2.repositories.CourseRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository repository;
    private final CourseMapper mapper;
    private final StudentMapper studentMapper;

    public void create(CreateCourseDto dto) {
        Course course = mapper.toCourse(dto);
        repository.save(course);
    }

    public Course findByCodeAndClass(String code, Integer courseClass) {
        return repository.findByCodeAndCourseClass(code, courseClass);
    }

    public List<FindStudentDto> findStudentsByCodeAndClass(String code, Integer courseClass) {
        Course course = findByCodeAndClass(code, courseClass);
        return course.getStudents().stream()
            .map(studentMapper::toFindStudentDto)
            .collect(Collectors.toList());
    }
}
