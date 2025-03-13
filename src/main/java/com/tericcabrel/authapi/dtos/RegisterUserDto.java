package com.tericcabrel.authapi.dtos;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
