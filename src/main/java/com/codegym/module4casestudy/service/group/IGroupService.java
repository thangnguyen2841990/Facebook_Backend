package com.codegym.module4casestudy.service.group;

import com.codegym.module4casestudy.model.entity.Group;
import com.codegym.module4casestudy.model.entity.ListFriend;
import com.codegym.module4casestudy.model.entity.UserInfo;
import com.codegym.module4casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IGroupService extends IGeneralService<Group> {
    public Page<Group>findByUserId(Long id, Pageable pageable);

   public Page<Group> findAllGroupOtherUserId(Long id, Pageable pageable);

    List<Group> findAllGroupOfUser(Long id);

}
