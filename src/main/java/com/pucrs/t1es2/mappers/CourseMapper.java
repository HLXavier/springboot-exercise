package com.pucrs.t1es2.mappers;

import org.springframework.stereotype.Component;

import com.pucrs.t1es2.dtos.requests.CreateCourseDto;
import com.pucrs.t1es2.dtos.responses.FindCourseDto;
import com.pucrs.t1es2.entities.Course;

@Component
public class CourseMapper {

    public Course toCourse(CreateCourseDto dto) {
        return Course.builder()
            .code(dto.getCode())
            .name(dto.getName())
            .courseClass(dto.getCourseClass())
            .schedule(dto.getSchedule())
            .build();
    }

    public FindCourseDto toFindCourseDto(Course course) {
        return FindCourseDto.builder()
            .code(course.getCode())
            .name(course.getName())
            .courseClass(course.getCourseClass())
            .schedule(course.getSchedule())
            .build();
    }
}
