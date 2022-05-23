package com.codegym.module4casestudy.model.dto;

import com.codegym.module4casestudy.model.entity.User;
import com.codegym.module4casestudy.model.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessagerDTO {
    private Long id;

    private User sender;

    private User receiver;

    private String content;

    private boolean status;

    private String time;
}
