package org.example.tuk_market_v2.auth.dto.signin;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SigninRequest {

    private String email;
    private String password;

}
