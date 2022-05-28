package com.codegym.module4casestudy.service.postGroup;

import com.codegym.module4casestudy.model.entity.PostGroup;
import com.codegym.module4casestudy.service.IGeneralService;

import java.util.List;

public interface IPostGroupService extends IGeneralService<PostGroup> {
    List<PostGroup> listPost(Long groupId);

}
