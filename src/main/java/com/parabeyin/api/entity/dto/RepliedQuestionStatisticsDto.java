package com.parabeyin.api.entity.dto;
/* Created by Farhad on 2020-04-19 */

import lombok.Data;

import java.util.List;

@Data
public class RepliedQuestionStatisticsDto {

    private long question_id;
    private boolean yourAnswerIsCorrect = false;
    private long correctAnswerId;
    private List<AnswerStatisticsDto>  statistics;
}
