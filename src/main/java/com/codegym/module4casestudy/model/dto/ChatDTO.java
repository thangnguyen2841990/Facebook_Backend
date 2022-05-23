package com.codegym.module4casestudy.model.dto;

import com.codegym.module4casestudy.model.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatDTO {
    private Long id;
    private UserInfo user1;

    private UserInfo user2;

    private String lastContent;

    private String dateCreated;
}
