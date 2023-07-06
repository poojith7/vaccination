package com.App.Vaccination.controller;

import com.App.Vaccination.model.User;
import com.App.Vaccination.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/login")
    public ResponseEntity adminLogin(@RequestBody User user) {
        if(user.getPassword() != null && user.getUsername() != null) {
            String pass = userRepo.findPassword(user.getUsername());
            User dbUser = userRepo.findByUsername(user.getUsername());
            if(pass.equals(user.getPassword()) && dbUser.isAdmin())
                return ResponseEntity.ok("Login Success");
        }
        return ResponseEntity.badRequest().body("Login Unsuccessful");
    }

}
