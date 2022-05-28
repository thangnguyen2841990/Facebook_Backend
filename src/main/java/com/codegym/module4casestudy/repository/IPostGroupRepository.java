package com.codegym.module4casestudy.repository;

import com.codegym.module4casestudy.model.entity.PostGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostGroupRepository extends JpaRepository<PostGroup, Long> {
    @Query(value = "select * from post_group where status_check = true and group_id = ?1 ", nativeQuery = true)
    List<PostGroup> listPost(Long groupId);
}
