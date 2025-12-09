package org.example.tuk_market_v2.auth.dto.signup;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignupRequest {

    @NotBlank(message = "필수 입력사항입니다.")
    @Email
    private String email;

    @NotBlank(message = "필수 입력사항입니다.")
    private String password;

    @NotBlank(message = "필수 입력사항입니다.")
    private String username;
}
