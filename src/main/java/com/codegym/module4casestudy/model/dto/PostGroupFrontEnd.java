package com.codegym.module4casestudy.model.dto;

import com.codegym.module4casestudy.model.entity.ImagePostGroup;
import com.codegym.module4casestudy.model.entity.ImagePostUser;
import com.codegym.module4casestudy.model.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostGroupFrontEnd {
    private Long postGroupId;

    private String content;

    private ImagePostGroup[] listImage;

    private String dateCreated;

    private UserInfo userInfo;
}
