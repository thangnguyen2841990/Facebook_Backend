package com.codegym.module4casestudy.service.groupStatus;

import com.codegym.module4casestudy.model.entity.GroupStatus;
import com.codegym.module4casestudy.service.IGeneralService;

import java.util.List;

public interface IGroupStatusService extends IGeneralService<GroupStatus> {
    List<GroupStatus> findAll();
}
