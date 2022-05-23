package com.codegym.module4casestudy.repository;

import com.codegym.module4casestudy.model.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IChatRepository extends JpaRepository<Chat, Long> {
    @Query(value = "select * from chat where user1_id in (?1, ?2) and user2_id in (?1, ?2)", nativeQuery = true)
    Optional<Chat> findChat(Long user1Id, Long user2Id);
    @Query(value = "select * from chat where user1_id = ?1 or user2_id =?1",nativeQuery = true)
    List<Chat> getAllChatByUser(Long userId);
}
