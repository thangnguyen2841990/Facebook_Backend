package com.codegym.module4casestudy.service.user;

import com.codegym.module4casestudy.model.dto.ChangePassword;
import com.codegym.module4casestudy.model.entity.User;
import com.codegym.module4casestudy.model.entity.UserInfo;
import com.codegym.module4casestudy.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    User findByUsername(String username);

    Iterable<User> findAll();

    User saveAdmin(User user);

    List<User> findAllUser();

    User saveBlock(User user);

}
