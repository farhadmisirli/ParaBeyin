package com.parabeyin.api.entity.dto;
/* Created by Farhad on 2020-04-15 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {

    @NotEmpty
    private String reason;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String message;

}

