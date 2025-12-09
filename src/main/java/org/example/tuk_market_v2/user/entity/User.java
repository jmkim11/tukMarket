package org.example.tuk_market_v2.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.tuk_market_v2.user.entity.utils.Role;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    private Role role;
    private String username;
    private LocalDateTime createdAt;

    public static User to(String email,
                          String password,
                          String username){
        return User.builder()
                .email(email)
                .password(password)
                .username(username)
                .createdAt(LocalDateTime.now())
                .build();

    }
}
