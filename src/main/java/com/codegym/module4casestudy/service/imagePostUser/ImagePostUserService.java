package com.codegym.module4casestudy.service.imagePostUser;

import com.codegym.module4casestudy.model.entity.ImagePostUser;
import com.codegym.module4casestudy.repository.IImagePostUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagePostUserService implements IImagePostUserService {
    @Autowired
    private IImagePostUserRepository imagePostUserRepository;

    @Override
    public Page<ImagePostUser> findAll(Pageable pageable) {
        return imagePostUserRepository.findAll(pageable);
    }

    @Override
    public Optional<ImagePostUser> findById(Long id) {
        return imagePostUserRepository.findById(id);
    }

    @Override
    public ImagePostUser save(ImagePostUser imagePostUser) {
        return imagePostUserRepository.save(imagePostUser);
    }

    @Override
    public void deleteById(Long id) {
            imagePostUserRepository.deleteById(id);
    }

    @Override
    public Iterable<ImagePostUser> findAll() {
        return imagePostUserRepository.findAll();
    }

    @Override
    public ImagePostUser[] listImage(Long postUser) {
        return this.imagePostUserRepository.listImage(postUser);
    }

    @Override
    public Optional<ImagePostUser> findByPostUserId(Long postUserId) {
        return imagePostUserRepository.findByPostUserId(postUserId);
    }

    @Override
    public ImagePostUser findImageById(Long imageId) {
        return imagePostUserRepository.findImageById(imageId);
    }


}
