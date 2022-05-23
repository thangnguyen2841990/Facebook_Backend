package com.codegym.module4casestudy.model.dto;

import com.codegym.module4casestudy.model.entity.StatusPost;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvatarForm {
    MultipartFile avatar;
    StatusPost status;
}
