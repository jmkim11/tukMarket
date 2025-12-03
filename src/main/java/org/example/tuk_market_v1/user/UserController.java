package org.example.tuk_market_v1.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.tuk_market_v1.user.dto.SigninRequest;
import org.example.tuk_market_v1.user.dto.SigninResponse;
import org.example.tuk_market_v1.user.dto.SignupRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@Valid @RequestBody SigninRequest request){
        SigninResponse response = userService.signin(request);

        if ("로그인 성공!".equals(response.getMessage())){
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest request){
        userService.signup(request);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
