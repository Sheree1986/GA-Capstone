package com.example.openaccessbackend.service;

import com.example.openaccessbackend.exception.InformationExistException;
import com.example.openaccessbackend.model.User;
import com.example.openaccessbackend.model.Request.LoginRequest;
import com.example.openaccessbackend.model.Response.LoginResponse;
import com.example.openaccessbackend.repository.UserRepository;
import com.example.openaccessbackend.security.JWTUtils;
import com.example.openaccessbackend.exception.InformationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public UserService() {
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User userObject) {
        System.out.println("service is calling createUser==>");
        if (!this.userRepository.existsByEmailAddress(userObject.getEmailAddress())) {
            userObject.setPassword(this.passwordEncoder.encode(userObject.getPassword()));
            return (User)this.userRepository.save(userObject);
        } else {
            throw new InformationExistException("user with email address " + userObject.getEmailAddress() + " already exists");
        }
    }

    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(loginRequest.getEmail());
        String jwt = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new LoginResponse(jwt));
    }

    public User findUserByEmailAddress(String email) {
        UserRepository userRepository = null;
        return ((UserRepository)userRepository).findUserByEmailAddress(email);
    }
}
