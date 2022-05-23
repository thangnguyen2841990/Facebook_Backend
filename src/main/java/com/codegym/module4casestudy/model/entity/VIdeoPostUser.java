package com.codegym.module4casestudy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VIdeoPostUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String video;

    @ManyToOne
    private PostUser postUser;

    public VIdeoPostUser(String video, PostUser postUser) {
        this.video = video;
        this.postUser = postUser;
    }
}
