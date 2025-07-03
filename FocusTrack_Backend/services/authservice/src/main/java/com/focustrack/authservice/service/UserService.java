package com.focustrack.authservice.service;

import com.focustrack.authservice.dto.RegisterRequest;
import com.focustrack.authservice.entity.Role;
import com.focustrack.authservice.entity.User;
import com.focustrack.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(RegisterRequest registerRequest) {
        try {
            User user = new User();
            user.setEmail(registerRequest.getEmail());
            user.setPassword(registerRequest.getPassword());
            if (registerRequest.getRole() != null) {
                user.setRole(registerRequest.getRole());
            } else {
                user.setRole(Role.USER);
            }
            userRepository.save(user);
        } catch (Exception e) {
            System.out.println("User Not Registered: " + e.getMessage());
        }
    }
}
