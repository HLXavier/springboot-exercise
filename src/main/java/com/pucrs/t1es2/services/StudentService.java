package com.pucrs.t1es2.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pucrs.t1es2.dtos.requests.CreateStudentDto;
import com.pucrs.t1es2.dtos.requests.EnrollDto;
import com.pucrs.t1es2.dtos.responses.FindCourseDto;
import com.pucrs.t1es2.dtos.responses.FindStudentDto;
import com.pucrs.t1es2.entity.Course;
import com.pucrs.t1es2.entity.Student;
import com.pucrs.t1es2.mappers.CourseMapper;
import com.pucrs.t1es2.mappers.StudentMapper;
import com.pucrs.t1es2.repositories.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository repository;
    private final CourseService courseService;
    private final StudentMapper mapper;
    private final CourseMapper courseMapper;

    public void create(CreateStudentDto dto) {
        String registration = Student.generateRegistration();
        Student student = mapper.toStudent(dto, registration);
        repository.save(student);
    }

    public FindStudentDto findByRegistration(String registration) {
        Student student = repository.findByRegistration(registration);
        return mapper.toFindStudentDto(student);
    }

    public List<FindStudentDto> findAll() {
        List<Student> students = repository.findAll();
        return students.stream()
            .map(mapper::toFindStudentDto)
            .collect(Collectors.toList());
    }

    public List<FindStudentDto> findByName(String name) {
        List<Student> students = repository.findByNameContaining(name);
        return students.stream()
            .map(mapper::toFindStudentDto)
            .collect(Collectors.toList());
    }

    public void enroll(EnrollDto dto) {
        Student student = repository.findByRegistration(dto.getRegistration());
        Course course = courseService.findByCodeAndClass(dto.getCode(), dto.getCourseClass());

        student.getCourses().add(course);
        repository.save(student);
    }

    public List<FindCourseDto> findCoursesByRegistration(String registration) {
        Student student = repository.findByRegistration(registration);
        return student.getCourses().stream()
            .map(courseMapper::toFindCourseDto)
            .collect(Collectors.toList());
    }
}