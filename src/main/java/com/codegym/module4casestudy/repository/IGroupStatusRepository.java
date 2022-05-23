package com.codegym.module4casestudy.repository;

import com.codegym.module4casestudy.model.entity.GroupStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGroupStatusRepository extends JpaRepository<GroupStatus, Long> {
}
