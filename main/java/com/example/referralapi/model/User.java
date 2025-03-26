package com.example.referralapi.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private boolean profileCompleted=false;

    private String referralCode; // Unique code for each user

    @ManyToOne
    @JoinColumn(name = "referrer_id") // Links referred user to referrer
    private User referrer;

    // ✅ Generates a referral code only when the user is first saved
    @PrePersist
    public void generateReferralCode() {
        if (this.referralCode == null || this.referralCode.isEmpty()) {
            this.referralCode = UUID.randomUUID().toString().substring(0, 8);
        }
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public boolean isProfileCompleted() { return profileCompleted; }
    public void setProfileCompleted(boolean profileCompleted) { this.profileCompleted = profileCompleted; }

    public String getReferralCode() { return referralCode; }
    public void setReferralCode(String referralCode) { this.referralCode = referralCode; }

    public User getReferrer() { return referrer; }
    public void setReferrer(User referrer) { this.referrer = referrer; }
}
