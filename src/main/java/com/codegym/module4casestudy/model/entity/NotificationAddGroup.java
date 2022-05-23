package com.codegym.module4casestudy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="notificationAddGroups" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationAddGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserInfo fromUser;


    @ManyToOne
    private UserInfo toUser;

    @ManyToOne
    private Group group;

    private int status;
}
