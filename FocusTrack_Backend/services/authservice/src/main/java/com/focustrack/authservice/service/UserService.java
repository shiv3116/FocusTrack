package com.focustrack.authservice.service;

import com.focustrack.authservice.dto.LoginRequest;
import com.focustrack.authservice.dto.RegisterRequest;
import com.focustrack.authservice.entity.Role;
import com.focustrack.authservice.entity.User;
import com.focustrack.authservice.exception.UserNotPresentException;
import com.focustrack.authservice.exception.UserNotRegisteredException;
import com.focustrack.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public void registerUser(RegisterRequest registerRequest) {
        try {
            User user = new User();
            user.setEmail(registerRequest.getEmail());
            user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            if (registerRequest.getRole() != null) {
                user.setRole(registerRequest.getRole());
            } else {
                user.setRole(Role.USER);
            }
            userRepository.save(user);
        } catch (Exception e) {
            throw new UserNotRegisteredException(e);
        }
    }

    public String loginUser(LoginRequest loginRequest) {
        try {
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            if(auth.isAuthenticated()) {
                return jwtService.generateToken(loginRequest.getEmail());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Invalid Login Information";
    }

    public void deleteUser(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        try {
            userRepository.delete(user.get());
        } catch (Exception e) {
            throw new UserNotPresentException(e);
        }
    }
}
