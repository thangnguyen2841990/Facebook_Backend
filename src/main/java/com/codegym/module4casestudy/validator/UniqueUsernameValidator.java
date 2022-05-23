package com.codegym.module4casestudy.validator;


import com.codegym.module4casestudy.model.entity.User;
import com.codegym.module4casestudy.repository.IUserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    private IUserRepository userRepository;

    public UniqueUsernameValidator(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return false;
        }
        return true;
    }
}