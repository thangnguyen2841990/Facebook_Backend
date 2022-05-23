package com.codegym.module4casestudy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String userName;
    private Date dateCreated;
    private Integer totalFriend;
    private boolean status;
}
