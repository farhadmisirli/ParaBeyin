package com.parabeyin.api.entity;
/* Created by Farhad on 2020-04-15 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "pb_contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String reason;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String message;

    @CreationTimestamp
    @JsonFormat(pattern="YYYY-MM-dd HH:mm:ss")
    private LocalDateTime created_at;

}

