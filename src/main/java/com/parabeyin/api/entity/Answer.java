package com.parabeyin.api.entity;
/* Created by Farhad on 2020-04-18 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "pb_answers")
public class Answer {

    @Id
    private Long id;
    private String content;

    @Column(name = "question_id")
    private long question;

    private short sort;
    private boolean correct;

}
