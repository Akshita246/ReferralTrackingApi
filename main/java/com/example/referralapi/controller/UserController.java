package com.example.referralapi.controller;

import com.example.referralapi.model.User;
import com.example.referralapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // Signup API (Allows signup with or without referral code)
    @PostMapping("/signup")
    public User signUp(@RequestBody User user, @RequestParam(required = false) String referralCode) {
        return userService.signUp(user, referralCode);
    }

    // Complete Profile API
    @PostMapping("/complete-profile/{userId}")
    public User completeProfile(@PathVariable Long userId) {
        return userService.completeProfile(userId);
    }

    // Updated Get Referrer API
    @GetMapping("/referrer/{userId}")
    public ResponseEntity<User> getReferrer(@PathVariable Long userId) {
        Optional<User> user = userService.getReferrer(userId); // Fetch referrer
        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if user not found
        }
        return ResponseEntity.ok(user.get()); // Return referrer info
    }
    
    @GetMapping("/referral-report")
    public List<Map<String, Object>> getReferralReport() {
        return userService.getReferralReport();
    }

}
