package com.codegym.module4casestudy.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "friendship")
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "from_user_id")
    private UserInfo fromUser;

    @ManyToOne
    @JoinColumn(name = "to_user_id")
    private UserInfo toUser;

    private int status;

    public Friendship() {
    }

    public Friendship(UserInfo fromUser, UserInfo toUser, int status) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserInfo getFromUser() {
        return fromUser;
    }

    public void setFromUser(UserInfo fromUser) {
        this.fromUser = fromUser;
    }

    public UserInfo getToUser() {
        return toUser;
    }

    public void setToUser(UserInfo toUser) {
        this.toUser = toUser;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
