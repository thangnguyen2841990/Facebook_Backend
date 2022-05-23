package com.codegym.module4casestudy.repository;

import com.codegym.module4casestudy.model.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {

@Query(value = "select * from message where to_user_id = ?1 and from_user_id != to_user_id order by date_created desc",nativeQuery = true)
    List<Message>  findAllMessage(Long to_user_id);

@Query(value = "delete from message where to_user_id = ?1",nativeQuery = true)
    void deleteMessage(Long toUserId);


}
