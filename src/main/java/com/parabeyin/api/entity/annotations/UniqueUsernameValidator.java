package com.parabeyin.api.entity.annotations;
/* Created by Farhad on 2020-04-04 */

import com.parabeyin.api.entity.User;
import com.parabeyin.api.repository.UserRepository;
import com.parabeyin.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if(userService == null) { return true; }

        if(userService.existsByUsername(username)) { return false; }

        return true;

    }

}
