package com.example.openaccessbackend.controller;


import com.example.openaccessbackend.model.User;
import com.example.openaccessbackend.model.Request.LoginRequest;
import com.example.openaccessbackend.service.UserService;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        path = {"/auth/users"}
)
public class UserController {
    private UserService userService;
    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    public UserController() {
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping({"/register"})
    public User createUser(@RequestBody User userObject) {
        LOGGER.info("calling createUser method from controller");
        return this.userService.createUser(userObject);
    }

    @PostMapping({"/login"})
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        return this.userService.loginUser(loginRequest);
    }
}