package com.codegym.module4casestudy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private Date dateCreated;
    @ManyToOne
    private StatusPost status;


    @ManyToOne
    private UserInfo userInfo;


    public PostUser(String content, Date dateCreated, StatusPost status, UserInfo userInfo) {
        this.content = content;
        this.dateCreated = dateCreated;
        this.status = status;
        this.userInfo = userInfo;
    }
}
