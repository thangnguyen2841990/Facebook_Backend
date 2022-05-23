package com.codegym.module4casestudy.repository;

import com.codegym.module4casestudy.model.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IGroupRepository extends JpaRepository<Group, Long> {
    @Modifying // dùng đẻ triển khai câu query vì bảng này liên kiết với product nên gọi để xóa hết
    @Query(value = "call deleteGroup(?1)",nativeQuery = true)
    void deleteGroup(Long id);

    @Query(value = "select * from groups_ where user_id =?1",nativeQuery = true)
    Page<Group> findAllByUserId(Long id, Pageable pageable);

    @Query(value = "select * from groups_ where user_id != ?1 and group_status_id = 1 and id not in (select group_id from group_members where user_info_id = ?1 and status = 1)", nativeQuery = true)
    Page<Group> findAllGroupOtherUserId(Long id, Pageable pageable);

    @Query(value = "select * from groups_ where user_id =?1",nativeQuery = true)
    List<Group> findAllGroupOfUser(Long id);


}
