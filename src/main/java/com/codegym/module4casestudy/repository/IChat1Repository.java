package com.codegym.module4casestudy.repository;

import com.codegym.module4casestudy.model.entity.Chat1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChat1Repository extends JpaRepository<Chat1, Long> {
    @Query(value = "select * from chat1 where sender_id in (?1, ?2) and receiver_id in (?1, ?2)", nativeQuery = true)
    Iterable<Chat1> getAllHistoryBetweenTwoUser(Long user1Id, Long user2Id);

    @Query(value = "select * from chat1 where sender_id in (?1, ?2) and receiver_id in (?1, ?2)", nativeQuery = true)
    List<Chat1> listChatOfMe(Long senderId, Long receiverId);
}
