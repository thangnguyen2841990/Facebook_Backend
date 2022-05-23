package com.codegym.module4casestudy.service.likePostUser;

import com.codegym.module4casestudy.model.entity.LikePostUser;
import com.codegym.module4casestudy.repository.ILikePostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikePostUserService implements ILikePostUserService {
    @Autowired
    private ILikePostRepository likePostUserRepositoryl;


    @Override
    public Page<LikePostUser> findAll(Pageable pageable) {
        return likePostUserRepositoryl.findAll(pageable);
    }

    @Override
    public Optional<LikePostUser> findById(Long id) {
        return likePostUserRepositoryl.findById(id);
    }

    @Override
    public LikePostUser save(LikePostUser likePostUser) {
        return likePostUserRepositoryl.save(likePostUser);
    }

    @Override
    public void deleteById(Long id) {
        likePostUserRepositoryl.deleteById(id);
    }

    @Override
    public List<LikePostUser> findAll() {
        return likePostUserRepositoryl.findAll();
    }

    @Override
    public Optional<LikePostUser> findLikePostUserByUserInfoIdAndPostUserId(Long userInfoId, Long postUserId) {
        return this.likePostUserRepositoryl.findLikePostUserByUserInfoIdAndPostUserId(userInfoId, postUserId);
    }

    @Override
    public List<LikePostUser> totalLikeByPost(Long postUserId) {
        return this.likePostUserRepositoryl.totalLikeByPost(postUserId);
    }
}
