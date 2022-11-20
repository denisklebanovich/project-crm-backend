package com.dev.projectmanagementsystem.controllers;

import com.dev.projectmanagementsystem.models.User;
import com.dev.projectmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PutMapping
    public ResponseEntity<User> changePassword(String email, String oldPassword, String newPassword) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) return ResponseEntity.notFound().build();
        if (user.getPassword().equals(passwordEncoder.encode(oldPassword))) {
            user.setPassword(newPassword);
            return ResponseEntity.ok(userRepository.save(user));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) return ResponseEntity.notFound().build();
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public List<User> getAllByEmail(@RequestParam String email) {
        return userRepository.findAllByEmailContaining(email);
    }
}
