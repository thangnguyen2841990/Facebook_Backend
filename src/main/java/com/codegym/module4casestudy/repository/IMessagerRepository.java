package com.codegym.module4casestudy.repository;

import com.codegym.module4casestudy.model.entity.Messager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMessagerRepository extends JpaRepository<Messager, Long> {
    @Query(value = "select * from messager where from_user_id in (?1, ?2) and to_user_id in (?1, ?2) order by date_created", nativeQuery=true)
    List<Messager> findAllMessagers(Long from_user_id, Long to_user_id);
    @Query(value = "select * from messager where from_user_id = ?1 and to_user_id in () or to_user_id = ?1 order by date_created desc", nativeQuery = true)
    List<Messager> allMessOfUser(Long userId);

}
