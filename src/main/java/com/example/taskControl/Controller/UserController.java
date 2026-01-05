package com.example.taskControl.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskControl.Model.User;
import com.example.taskControl.Service.UserService;

import jakarta.websocket.server.PathParam;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathParam("id") Long id) {
        return userService.getUserById(id);
    }
    
    
    
}
