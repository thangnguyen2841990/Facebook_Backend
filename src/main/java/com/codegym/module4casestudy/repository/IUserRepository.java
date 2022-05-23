package com.codegym.module4casestudy.repository;

import com.codegym.module4casestudy.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query(value="select * from user", nativeQuery = true)
    List<User> findAllUser();

    @Modifying
    @Query(value = "call deleteUser(?1)", nativeQuery = true)
    void deleteUserByAdmin(Long id);


}
