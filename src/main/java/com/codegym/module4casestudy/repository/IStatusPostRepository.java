package com.codegym.module4casestudy.repository;

import com.codegym.module4casestudy.model.entity.StatusPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusPostRepository extends JpaRepository<StatusPost, Long> {
}
