package com.pucrs.t1es2.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pucrs.t1es2.dtos.requests.CreateCourseDto;
import com.pucrs.t1es2.dtos.responses.FindStudentDto;
import com.pucrs.t1es2.services.CourseService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("course")
public class CourseController {

    private final CourseService service;

    @PostMapping
    public void create(@RequestBody CreateCourseDto dto) {
        service.create(dto);
    }

    @GetMapping("students")
    public List<FindStudentDto> findCoursesByRegistration(@RequestParam String code, @RequestParam(name = "class") Integer courseClass) {
        return service.findStudentsByCodeAndClass(code, courseClass);
    }

}
