package com.pucrs.t1es2.dtos.requests;

import lombok.Getter;

@Getter
public class CreateStudentDto {
    private String name;
    private String cpf;
    private String address;
}
