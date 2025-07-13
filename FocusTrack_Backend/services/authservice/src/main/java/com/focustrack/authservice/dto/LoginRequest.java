package com.focustrack.authservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank(message = "Enter a Valid Email")
    @Email(message = "Invalid Email Address")
    private String email;

    @NotBlank(message = "Enter a Password")
    private String password;
}
