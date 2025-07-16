package com.focustrack.authservice.controller;

import com.focustrack.authservice.dto.LoginRequest;
import com.focustrack.authservice.dto.RegisterRequest;
import com.focustrack.authservice.service.ResponseService;
import com.focustrack.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RequestMapping("/focustrack/auth")
@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResponseService responseService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        userService.registerUser(registerRequest);
        responseService.setStatusCode(HttpStatus.CREATED.value());
        responseService.setMessage("User Registered Successfully");
        return new ResponseEntity<>(responseService, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest loginRequest) {
        String token = userService.loginUser(loginRequest);
        responseService.setStatusCode(0);
        responseService.setToken(token);
        return new ResponseEntity<>(responseService, HttpStatus.OK);
    }

    @PostMapping("/delete/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        responseService.setStatusCode(0);
        responseService.setMessage("User Deleted Successfully");
        return new ResponseEntity<>(responseService, HttpStatus.OK);
    }
}
