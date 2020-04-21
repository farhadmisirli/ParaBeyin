package com.parabeyin.api.entity;
/* Created by Farhad on 2020-04-19 */

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "pb_replied_answers")
public class RepliedAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long user;

    @Column(name = "game_id")
    private Long game;

    @Column(name = "question_id")
    private Long question;

    @Column(name = "answer_id")
    private Long answer;

    @CreationTimestamp
    private LocalDateTime created_at;
}
