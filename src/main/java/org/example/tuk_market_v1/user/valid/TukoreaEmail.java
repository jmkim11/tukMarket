package org.example.tuk_market_v1.user.valid;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TukoreaEmailValidator.class)
public @interface TukoreaEmail {
    String message() default "유효하지 않은 도메인입니다.";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
