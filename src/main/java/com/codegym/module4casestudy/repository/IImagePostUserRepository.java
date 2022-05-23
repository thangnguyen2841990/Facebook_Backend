package com.codegym.module4casestudy.repository;

import com.codegym.module4casestudy.model.entity.ImagePostUser;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IImagePostUserRepository extends JpaRepository<ImagePostUser, Long> {

    @Query(value = "select * from image_post_user where post_user_id = ?1", nativeQuery = true)
    ImagePostUser[] listImage(Long postUser);

    @Query(value = "select * from image_post_user where post_user_id = ?1", nativeQuery = true)
    Optional<ImagePostUser> findByPostUserId(Long postUserId);

    @Query(value = "select * from image_post_user where id = ?1",nativeQuery = true)
    ImagePostUser findImageById(Long imageId);

}
