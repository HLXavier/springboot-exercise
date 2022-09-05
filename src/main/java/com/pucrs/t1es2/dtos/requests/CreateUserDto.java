package com.pucrs.t1es2.dtos.requests;

import lombok.Getter;

@Getter
public class CreateUserDto {
    private String name;
    private String email;
    private String password;
}
