package com.codegym.module4casestudy.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Chat1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User receiver;

    private String content;

    private boolean status;

    private Date time;
}
