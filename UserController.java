package com.selfstudy.library.controllers;

import com.selfstudy.library.dto.UserDTO;
import com.selfstudy.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public UserDTO getProfile() {
        return userService.getProfile();
    }

    @PutMapping("/profile")
    public UserDTO updateProfile(@RequestBody UserDTO userDTO) {
        return userService.updateProfile(userDTO);
    }
}
