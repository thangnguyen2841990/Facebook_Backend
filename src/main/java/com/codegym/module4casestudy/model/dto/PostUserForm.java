package com.codegym.module4casestudy.model.dto;

import com.codegym.module4casestudy.model.entity.StatusPost;
import com.codegym.module4casestudy.model.entity.User;
import com.codegym.module4casestudy.model.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUserForm {

    private String content;

    private MultipartFile[] image;

    private StatusPost status;
}
