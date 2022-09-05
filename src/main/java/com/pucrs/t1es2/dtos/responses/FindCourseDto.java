package com.pucrs.t1es2.dtos.responses;

import com.pucrs.t1es2.entity.Schedule;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FindCourseDto {
    private String code;
    private String name;
    private int courseClass;
    private Schedule schedule;
}
