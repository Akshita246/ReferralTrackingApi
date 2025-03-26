package com.example.referralapi.service;

import com.example.referralapi.model.User;
import com.example.referralapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // User Signup
    @Transactional
    public User signUp(User user, String referrerCode) {
        // Check if email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        // Ensure referral code is generated
        if (user.getReferralCode() == null || user.getReferralCode().isEmpty()) {
            user.setReferralCode(generateReferralCode());
        }

        // Link referrer if a valid referral code is provided
        if (referrerCode != null && !referrerCode.isEmpty()) {
            Optional<User> referrer = userRepository.findByReferralCode(referrerCode);
            if (referrer.isPresent()) {
                user.setReferrer(referrer.get());
                System.out.println("User referred by: " + referrer.get().getEmail());
            } else {
                throw new RuntimeException("Invalid referral code");
            }
        }

        return userRepository.save(user);
    }

    // Complete Profile & Mark Referral as Successful
    @Transactional
    public User completeProfile(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setProfileCompleted(true);
        userRepository.save(user);

        // Mark referral as successful
        if (user.getReferrer() != null) {
            System.out.println("Referral successful for: " + user.getReferrer().getEmail());
        }

        return user;
    }

    // Get Referrer Details
    public Optional<User> getReferrer(Long userId) {
        return userRepository.findById(userId)
                .map(User::getReferrer);
    }

    // Helper: Generate Unique Referral Code
    private String generateReferralCode() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
    
    public List<Map<String, Object>> getReferralReport() {
        List<User> users = userRepository.findAll();
        
        List<Map<String, Object>> report = new ArrayList<>();
        for (User user : users) {
            Map<String, Object> data = new HashMap<>();
            data.put("userId", user.getId());
            data.put("name", user.getName());
            data.put("email", user.getEmail());
            data.put("referralCode", user.getReferralCode());
            data.put("referralsCount", userRepository.countByReferrer(user));
            data.put("completedReferrals", userRepository.countByReferrerAndProfileCompletedTrue(user));

            report.add(data);
        }
        return report;
    }

}
