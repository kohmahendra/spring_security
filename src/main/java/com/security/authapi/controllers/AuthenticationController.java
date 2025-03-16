package com.security.authapi.controllers;

import com.security.authapi.dtos.LoginUserDto;
import com.security.authapi.dtos.RegisterUserDto;
import com.security.authapi.entities.User;
import com.security.authapi.responses.LoginResponse;
import com.security.authapi.services.AuthenticationService;
import com.security.authapi.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(final JwtService jwtService, final AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

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

        final LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}