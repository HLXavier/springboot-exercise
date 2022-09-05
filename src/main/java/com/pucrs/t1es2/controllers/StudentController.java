package com.pucrs.t1es2.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pucrs.t1es2.dtos.requests.CreateStudentDto;
import com.pucrs.t1es2.dtos.requests.EnrollDto;
import com.pucrs.t1es2.dtos.responses.FindCourseDto;
import com.pucrs.t1es2.dtos.responses.FindStudentDto;
import com.pucrs.t1es2.services.StudentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("student")
public class StudentController {

    private final StudentService service;

    @PostMapping()
    public void create(@RequestBody CreateStudentDto dto) {
        service.create(dto);
    }

    @GetMapping("{registration}")
    public FindStudentDto findByRegistration(@PathVariable String registration) {
        return service.findByRegistration(registration);
    }

    @GetMapping
    public List<FindStudentDto> findAll() {
        return  service.findAll();
    }

    @GetMapping("name/{name}")
    public List<FindStudentDto> findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @PostMapping("enroll")
    public void enroll(@RequestBody EnrollDto dto) {
        service.enroll(dto);
    }

    @GetMapping("courses/{registration}")
    public List<FindCourseDto> findCoursesByRegistration(@PathVariable String registration) {
        return service.findCoursesByRegistration(registration);
    }
}
