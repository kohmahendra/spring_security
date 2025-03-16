package com.security.authapi.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginUserDto {
    private String email;
    private String password;
}
