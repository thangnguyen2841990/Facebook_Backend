package com.codegym.module4casestudy.service.statusPost;

import com.codegym.module4casestudy.model.entity.StatusPost;
import com.codegym.module4casestudy.service.IGeneralService;

import java.util.List;

public interface IStatusService extends IGeneralService<StatusPost> {
    List<StatusPost> findAll();
}
