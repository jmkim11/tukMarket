package org.example.tuk_market_v1.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.tuk_market_v1.user.valid.TukoreaEmail;

@Getter
@AllArgsConstructor
public class SignupRequest {

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email
    @TukoreaEmail
    private String email;

    @NotBlank(message = "활동명을 입력해주세요.")
    private String nickname;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 8, max = 20, message = "비밀번호는 8자리 이상 20자리 이하입니다.")
    @Pattern(
            regexp = "^(?=.*[!@#$&*])(?=.*[A-Za-z])(?=.*[0-9]).{8,20}$",
            message = "비밀번호는 숫자·영문·특수문자를 포함하여 작성해주세요."
    )
    private String password;


}
