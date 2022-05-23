package com.codegym.module4casestudy.service.messager;

import com.codegym.module4casestudy.model.entity.Messager;
import com.codegym.module4casestudy.service.IGeneralService;

import java.util.List;

public interface IMessagerService extends IGeneralService<Messager> {
    List<Messager> findAllMessagers(Long from_user_id, Long to_user_id);
    List<Messager> allMessOfUser(Long userId);

}
