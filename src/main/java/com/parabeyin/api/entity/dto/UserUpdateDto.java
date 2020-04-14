package com.parabeyin.api.entity.dto;
/* Created by Farhad on 2020-04-13 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.parabeyin.api.entity.annotations.UniqueEmail;
import com.parabeyin.api.entity.annotations.UniqueUsername;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class UserUpdateDto {

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    @NotBlank
    @Email
    private String email;

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    @NotNull
    private Character gender;

    private String profile_image;


}
