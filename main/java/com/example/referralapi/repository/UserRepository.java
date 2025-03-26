package com.example.referralapi.repository;

import com.example.referralapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	int countByReferrer(User referrer);
	int countByReferrerAndProfileCompletedTrue(User referrer);

	Optional<User> findByEmail(String email); 
    Optional<User> findByReferralCode(String referralCode);
}
