package com.parabeyin.api.entity.dto;
/* Created by Farhad on 2020-04-18 */

import com.parabeyin.api.entity.Answer;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

public class QuestionDto {

    private Long id;
    private String content;

    private short duration;
    private boolean active;

    @Transient
    private List<Answer> answers;

}
