package com.parabeyin.api.entity;
/* Created by Farhad on 2020-04-15 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "pb_pages")
public class Page {

    @Id
    @JsonIgnore
    private Long id;

    private String title;
    private String content;
    private String slug;

    @JsonIgnore
    private Boolean active;
}
