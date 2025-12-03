package org.example.tuk_market_v1.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class SigninResponse {
    private Long userId;
    private String email;
    private String message;

}
