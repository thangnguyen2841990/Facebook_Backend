package com.codegym.module4casestudy.service.postGroup;

import com.codegym.module4casestudy.model.entity.PostGroup;
import com.codegym.module4casestudy.repository.IPostGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostGroupService implements IPostGroupService{
    @Autowired
    private IPostGroupRepository postGroupRepository;
    @Override
    public Page<PostGroup> findAll(Pageable pageable) {
        return postGroupRepository.findAll(pageable);
    }

    @Override
    public Optional<PostGroup> findById(Long id) {
        return postGroupRepository.findById(id);
    }

    @Override
    public PostGroup save(PostGroup postGroup) {
        return postGroupRepository.save(postGroup);
    }

    @Override
    public void deleteById(Long id) {
            postGroupRepository.deleteById(id);
    }

    @Override
    public List<PostGroup> listPost(Long groupId) {
        return postGroupRepository.listPost(groupId);
    }
}
