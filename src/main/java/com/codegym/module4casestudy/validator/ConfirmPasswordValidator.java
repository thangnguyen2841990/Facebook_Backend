package com.codegym.module4casestudy.validator;


import com.codegym.module4casestudy.model.dto.PasswordForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmPasswordValidator implements ConstraintValidator<PasswordConfirm, PasswordForm> {
    @Override
    public boolean isValid(PasswordForm passwordForm, ConstraintValidatorContext context) {
        return passwordForm.getPassword().equals(passwordForm.getConfirmPassword());
    }
}