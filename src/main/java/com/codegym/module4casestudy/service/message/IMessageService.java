package com.codegym.module4casestudy.service.message;

import com.codegym.module4casestudy.model.entity.Message;
import com.codegym.module4casestudy.service.IGeneralService;

import java.util.List;

public interface IMessageService extends IGeneralService<Message> {

    List<Message> findAllMessage(Long to_user_id);
    void deleteMessage(Long toUserId);


}
