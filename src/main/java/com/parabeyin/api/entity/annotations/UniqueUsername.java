package com.parabeyin.api.entity.annotations;
/* Created by Farhad on 2020-04-04 */

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueUsernameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface UniqueUsername {

    public String message() default "There is already user with this email!";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};

}