package com.codegym.module4casestudy.repository;

import com.codegym.module4casestudy.model.entity.ImagePostGroup;
import com.codegym.module4casestudy.model.entity.ImagePostUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IImagePostGroup  extends JpaRepository<ImagePostGroup, Long> {
    @Query(value = "select * from image_post_group where post_group_id = ?1", nativeQuery = true)
    ImagePostGroup[] listImage(Long postGroupId);
}
