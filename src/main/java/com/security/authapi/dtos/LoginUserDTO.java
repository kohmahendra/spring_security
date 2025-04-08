package com.security.authapi.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginUserDTO {
    private String email;
    private String password;
}
