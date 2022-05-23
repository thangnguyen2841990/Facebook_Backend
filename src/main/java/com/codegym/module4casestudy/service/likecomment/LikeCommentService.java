package com.codegym.module4casestudy.service.likecomment;

import com.codegym.module4casestudy.model.entity.LikeComment;
import com.codegym.module4casestudy.repository.ILikeCommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeCommentService implements ILikeCommentService{

    @Autowired
    private ILikeCommentRepo likeCommentRepo;
    @Override
    public Page<LikeComment> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<LikeComment> findById(Long id) {
        return likeCommentRepo.findById(id);
    }

    @Override
    public LikeComment save(LikeComment likeComment) {
        return likeCommentRepo.save(likeComment);
    }

    @Override
    public void deleteById(Long id) {
            likeCommentRepo.deleteById(id);
    }

    @Override
    public Optional<LikeComment> findLikeCommentByUser(Long cmPostUserId, Long fromUserId) {
        return likeCommentRepo.findLikeCommentByUser(cmPostUserId,fromUserId);
    }

    @Override
    public List<LikeComment> listLikeComments(Long cmPostUserId) {
        return likeCommentRepo.listLikeComments(cmPostUserId);
    }
}
