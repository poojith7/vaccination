package com.App.Vaccination.controller;

import com.App.Vaccination.model.User;
import com.App.Vaccination.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User user) {
        userRepo.save(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        if(user.getPassword() != null && user.getUsername() != null) {
            String password = userRepo.findPassword(user.getUsername());
            if(user.getPassword().equals(password))
                return "Login success";
        }
        return "Login Unsuccessful";
    }

}
