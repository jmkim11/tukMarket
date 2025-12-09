package org.example.tuk_market_v2.auth;

import lombok.RequiredArgsConstructor;
import org.example.tuk_market_v2.auth.dto.signin.SigninRequest;
import org.example.tuk_market_v2.auth.dto.signin.SigninResponse;
import org.example.tuk_market_v2.auth.dto.signup.SignupRequest;
import org.example.tuk_market_v2.auth.dto.signup.SignupResponse;
import org.example.tuk_market_v2.user.entity.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    public SignupResponse createUser(SignupRequest request) {

        if (authRepository.existsByEmail(request.getEmail())){
            throw new IllegalArgumentException("이미 사용중인 이메일입니다.");
        }

        User user = User.to(request.getEmail(),
                request.getPassword(),
                request.getUsername());

        User saved = authRepository.save(user);

        return SignupResponse.from(saved);
    }

    public SigninResponse signIn(SigninRequest request){

        if (!authRepository.existsByEmail(request.getEmail())){
            throw new IllegalArgumentException("정보가 없습니다.");
        }

        User user = authRepository.findUserByEmail(request.getEmail());

        return SigninResponse.from(user);
    }
}
