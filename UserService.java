package com.selfstudy.library.services;

import com.selfstudy.library.dto.UserDTO;
import com.selfstudy.library.entities.User;
import com.selfstudy.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired private UserRepository userRepository;

    public UserDTO getProfile() {
        // For simplicity, fetch first user (in real app, use SecurityContext)
        User user = userRepository.findAll().stream().findFirst().orElseThrow();
        return new UserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getRole().getName());
    }

    public UserDTO updateProfile(UserDTO dto) {
        User user = userRepository.findById(dto.getId()).orElseThrow();
        user.setEmail(dto.getEmail());
        userRepository.save(user);
        return new UserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getRole().getName());
    }
}
