package com.parabeyin.api.entity.dto;
/* Created by Farhad on 2020-04-19 */

import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AnswerPostDto {

    @NotNull
    private int answer_id;

}
