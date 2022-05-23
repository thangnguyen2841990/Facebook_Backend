package com.codegym.module4casestudy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImagePostUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    @ManyToOne
    private PostUser postUser;

    public ImagePostUser(String image, PostUser postUser) {
        this.image = image;
        this.postUser = postUser;
    }


}
