package com.codegym.module4casestudy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private UserInfo user1;

    @OneToOne
    private UserInfo user2;

    private String lastContent;

    private Date dateCreated;

    public Chat(UserInfo user1, UserInfo user2) {
        this.user1 = user1;
        this.user2 = user2;
    }
}
