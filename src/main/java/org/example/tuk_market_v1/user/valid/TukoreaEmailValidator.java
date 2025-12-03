package org.example.tuk_market_v1.user.valid;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TukoreaEmailValidator implements ConstraintValidator<TukoreaEmail, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext ctx) {
        return value.toLowerCase().endsWith("@tukorea.ac.kr");
    }
}
