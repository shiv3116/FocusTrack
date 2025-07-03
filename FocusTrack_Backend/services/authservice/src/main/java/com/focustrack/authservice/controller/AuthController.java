package com.focustrack.authservice.controller;

import com.focustrack.authservice.dto.RegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RequestMapping("/focustrack")
@RestController
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<?> registerUsre(@Valid @RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body("User Registered Successfully");
    }
}
