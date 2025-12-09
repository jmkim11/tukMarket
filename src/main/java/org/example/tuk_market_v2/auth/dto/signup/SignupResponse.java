package org.example.tuk_market_v2.auth.dto.signup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.tuk_market_v2.user.entity.User;

import java.time.LocalDateTime;

@Getter@Setter
@Builder
@AllArgsConstructor
public class SignupResponse {
    private Long userId;
    private String username;
    private String email;
    private LocalDateTime createdAt;

    public static SignupResponse from(User user){
        return SignupResponse.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
