package org.example.tuk_market_v2.auth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.tuk_market_v2.auth.dto.signin.SigninRequest;
import org.example.tuk_market_v2.auth.dto.signin.SigninResponse;
import org.example.tuk_market_v2.auth.dto.signup.SignupRequest;
import org.example.tuk_market_v2.auth.dto.signup.SignupResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Auth", description = "인증/인가 관련 API")
public class AuthController {
    private final AuthService authService;

    @Operation(summary = "회원가입", description = "이메일, 비밀번호, 닉네임으로 회원가입을 진행합니다.")
    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody @Valid SignupRequest request){
        SignupResponse body = authService.createUser(request);
        return ResponseEntity.ok(body);
    }

    @Operation(summary = "로그인", description = "이메일, 비밀번호로 로그인을 진행합니다.")
    @PostMapping("/signin")
    public ResponseEntity<SigninResponse> signin(@RequestBody @Valid SigninRequest request){
        SigninResponse body = authService.signIn(request);
        return ResponseEntity.ok(body);
    }
}
