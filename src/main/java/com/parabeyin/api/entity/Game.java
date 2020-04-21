package com.parabeyin.api.entity;
/* Created by Farhad on 2020-04-18 */


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "pb_games")
public class Game {

    @Id
    private Long id;
    private String title;

    @JsonFormat(pattern="YYYY-MM-dd HH:mm:ss")
    private Date start_date;

    private String media_url;
    private boolean active;

    @Transient
    private List<Question> questions;

}
