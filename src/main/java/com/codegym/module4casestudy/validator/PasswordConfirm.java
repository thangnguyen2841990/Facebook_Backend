package com.codegym.module4casestudy.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ConfirmPasswordValidator.class})
public @interface PasswordConfirm {
    String message() default "RePassword isn't match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}