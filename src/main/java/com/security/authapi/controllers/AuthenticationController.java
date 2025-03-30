package com.security.authapi.controllers;

import com.security.authapi.dtos.LoginUserDto;
import com.security.authapi.dtos.RegisterUserDto;
import com.security.authapi.entities.User;
import com.security.authapi.mapper.UserMappper;
import com.security.authapi.responses.LoginResponse;
import com.security.authapi.services.AuthenticationService;
import com.security.authapi.services.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@AllArgsConstructor
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;
    private final UserMappper userMappper;


    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody final RegisterUserDto registerUserDto) {
        final User registeredUser = authenticationService.signup(registerUserDto);
        registeredUser.setPassword(null);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody final LoginUserDto loginUserDto) {
        final User authenticatedUser = authenticationService.authenticate(loginUserDto);

        final String jwtToken = jwtService.generateToken(authenticatedUser);

        final LoginResponse loginResponse = LoginResponse.builder().token(jwtToken).user(userMappper.getUserDto(authenticatedUser)).
                expiresIn(jwtService.getExpirationTime()).build();

        return ResponseEntity.ok(loginResponse);
    }
}