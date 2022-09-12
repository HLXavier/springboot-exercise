package com.pucrs.t1es2.dtos.requests;

import com.pucrs.t1es2.entities.Schedule;

import lombok.Getter;

@Getter
public class CreateCourseDto {
    private String code;
    private String name;
    private int courseClass;
    private Schedule schedule;
}