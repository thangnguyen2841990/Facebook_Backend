package com.codegym.module4casestudy.service.commentPostUser;

import com.codegym.module4casestudy.model.entity.CommentPostUser;
import com.codegym.module4casestudy.repository.ICommentPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentPostUserService implements ICommentPostUserService {

    @Autowired
    private ICommentPostRepository iCommentPostRepository;

    @Override
    public Page<CommentPostUser> findAll(Pageable pageable) {
        return iCommentPostRepository.findAll(pageable);
    }

    @Override
    public Optional<CommentPostUser> findById(Long id) {
        return iCommentPostRepository.findById(id);
    }

    @Override
    public CommentPostUser save(CommentPostUser commentPostUser) {
        return iCommentPostRepository.save(commentPostUser);
    }

    @Override
    public void deleteById(Long id) {
        iCommentPostRepository.deleteById(id);
    }


    @Override
    public List<CommentPostUser> displayAllCommentOfPost(Long postUserId) {
        return iCommentPostRepository.displayAllCommentOfPost(postUserId);
    }
}
