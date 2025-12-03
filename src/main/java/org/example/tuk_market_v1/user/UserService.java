package org.example.tuk_market_v1.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.tuk_market_v1.user.dto.SigninRequest;
import org.example.tuk_market_v1.user.dto.SigninResponse;
import org.example.tuk_market_v1.user.dto.SignupRequest;
import org.example.tuk_market_v1.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void signup(SignupRequest request){
        User user = User.to(request.getEmail(),
                request.getPassword(),
                request.getNickname());

        userRepository.save(user);
    }

    public SigninResponse signin(@Valid SigninRequest request) {
        User user = userRepository.findUserByEmail(request.getEmail())
                .orElse(null);

        if (user == null){
            return SigninResponse.builder()
                    .userId(null)
                    .email(null)
                    .message("로그인 실패")
                    .build();
        }

        if (!user.getPassword().equals(request.getPassword())){
            return SigninResponse.builder()
                    .userId(user.getId())
                    .email(user.getEmail())
                    .message("로그인 실패")
                    .build();
        }

        return SigninResponse.builder()
                .userId(user.getId())
                .email(user.getEmail())
                .message("로그인 성공!")
                .build();
    }
}
