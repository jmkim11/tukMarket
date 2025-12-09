package org.example.tuk_market_v2.auth;

import org.example.tuk_market_v2.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    boolean findByEmail(String email);

    User findUserByEmail(String email);
}
