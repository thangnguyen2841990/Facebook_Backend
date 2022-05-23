package com.codegym.module4casestudy.service.userInfo;

import com.codegym.module4casestudy.model.entity.UserInfo;
import com.codegym.module4casestudy.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface IUserInfoService extends IGeneralService<UserInfo> {
    Long findUserId(String email, String phone_number) ;

    Optional<UserInfo> findByUserId(Long userId);

    List<UserInfo> showAllUserInfo(Long currentUserId);

    List<UserInfo> findAllUser();

    List<UserInfo> findByFullNameContaining(String fullName);


}
