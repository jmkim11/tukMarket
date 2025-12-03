package org.example.tuk_market_v1.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.tuk_market_v1.user.valid.TukoreaEmail;

@Getter
@AllArgsConstructor
public class SigninRequest {

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email
    @TukoreaEmail
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;
}
