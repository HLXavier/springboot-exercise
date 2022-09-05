package com.pucrs.t1es2.dtos.responses;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FindStudentDto {
    private String registration;
    private String name;
    private String cpf;
    private String address;
}
