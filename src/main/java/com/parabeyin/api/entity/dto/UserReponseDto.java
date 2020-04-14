package com.parabeyin.api.entity.dto;
/* Created by Farhad on 2020-04-13 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

@Data
public class UserReponseDto {

    private int id;

    private String firstname;

    private String lastname;

    private String username;

    private String email;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    private Character gender;

    private String profile_image;

}
