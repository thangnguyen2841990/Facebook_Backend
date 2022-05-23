package com.codegym.module4casestudy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserInfo fromUser;

    @ManyToOne
    private UserInfo toUser;

    private Date dateCreated;

    private String content;
    private int status;

    public Message(UserInfo fromUser, UserInfo toUser, Date dateCreated) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.dateCreated = dateCreated;
    }
}
