package com.codegym.module4casestudy.model.dto;

import com.codegym.module4casestudy.model.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    private UserInfo userinfo;

    private List<PostUserFrontEnd> postUserFrontEnds;


}
