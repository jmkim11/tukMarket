package org.example.tuk_market_v2.auth.dto.signin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.tuk_market_v2.user.entity.User;

@Getter@Setter
@AllArgsConstructor
@Builder
public class SigninResponse {

    private String username;

    public static SigninResponse from(User user){
        return SigninResponse.builder()
                .username(user.getUsername())
                .build();
    }
}
