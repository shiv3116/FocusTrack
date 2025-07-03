package com.focustrack.authservice.dto;

import com.focustrack.authservice.entity.Role;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Email is Required")
    @Email(message = "Not a valid Email")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password should be minimum 8 Characters long")
    @Size(max = 255, message = "Password should not be more than 255 Characters")
    private String password;

    private Role role;
}
