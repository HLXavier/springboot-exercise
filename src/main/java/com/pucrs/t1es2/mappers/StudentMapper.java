package com.pucrs.t1es2.mappers;

import org.springframework.stereotype.Component;

import com.pucrs.t1es2.dtos.requests.CreateStudentDto;
import com.pucrs.t1es2.dtos.responses.FindStudentDto;
import com.pucrs.t1es2.entity.Student;

@Component
public class StudentMapper {

    public Student toStudent(CreateStudentDto dto, String registration) {
        return Student.builder()
            .registration(registration)
            .name(dto.getName())
            .cpf(dto.getCpf())
            .address(dto.getAddress())
            .build();
    }

    public FindStudentDto toFindStudentDto(Student student) {
        return  FindStudentDto.builder()
            .registration(student.getRegistration())
            .name(student.getName())
            .cpf(student.getCpf())
            .address(student.getAddress())
            .build();
    }
}
