package com.focustrack.authservice.controller;

import com.focustrack.authservice.dto.RegisterRequest;
import com.focustrack.authservice.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RequestMapping("/focustrack/auth")
@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        ResponseEntity<?> response = null;
        try {
            userService.registerUser(registerRequest);
            response = ResponseEntity.status(HttpStatus.CREATED).body("User Registered Successfully");
        } catch (Exception e) {
            System.out.println("Error occured: "+e.getMessage());
        }
        return response;
    }
}
