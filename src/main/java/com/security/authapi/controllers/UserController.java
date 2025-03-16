package com.security.authapi.controllers;

import com.security.authapi.entities.User;
import com.security.authapi.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public String authenticatedUser() {
        return "success";
    }

    @GetMapping
    public ResponseEntity<List<User>> allUsers() {
        final List<User> users = userService.allUsers();
        return ResponseEntity.ok(users);
    }
}
