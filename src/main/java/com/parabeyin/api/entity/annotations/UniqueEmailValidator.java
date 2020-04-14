package com.parabeyin.api.entity.annotations;
/* Created by Farhad on 2020-04-04 */

import com.parabeyin.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        if(userService == null) { return true; }

        if(userService.existsByEmail(email)) { return false; }

        return true;
    }

}
