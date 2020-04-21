package com.parabeyin.api.entity.dto;
/* Created by Farhad on 2020-04-19 */

import com.parabeyin.api.entity.Answer;
import com.parabeyin.api.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.List;


public class AnswerStatisticsDto implements Serializable  {
    private long answer_id;
    private long count;

    public AnswerStatisticsDto() {
    }

    public AnswerStatisticsDto(long a, long b) {
        this.answer_id  = a;
        this.count = b;
    }

    public long getAnswer() {
        return answer_id;
    }

    public void setAnswer(long answer) {
        this.answer_id = answer;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
