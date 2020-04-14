package com.parabeyin.api.entity;
/* Created by Farhad on 2020-03-31 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.parabeyin.api.entity.annotations.UniqueEmail;
import com.parabeyin.api.entity.annotations.UniqueUsername;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table(name="pb_users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    @NotBlank
    @UniqueUsername(message = "This username already in use")
    private String username;

    @NotBlank
    @Email
    @UniqueEmail(message = "This username already in use")
    private String email;

    @NotBlank
    private String password;

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    @NotNull
    private Character gender;

    private String profile_image;



}

