package com.parabeyin.api.entity;
/* Created by Farhad on 2020-04-17 */

import com.parabeyin.api.entity.dto.AnswerResponseDto;
import com.parabeyin.api.entity.dto.AnswerStatisticsDto;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "pb_questions")
public class Question {

    @Id
    private Long id;
    private String content;

    @Column(name = "game_id")
    private long game;

    private short duration;
    private boolean active;

    @Transient
    private List<AnswerResponseDto> answers;

}
