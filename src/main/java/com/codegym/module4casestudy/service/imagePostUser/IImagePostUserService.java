package com.codegym.module4casestudy.service.imagePostUser;

import com.codegym.module4casestudy.model.entity.ImagePostUser;
import com.codegym.module4casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IImagePostUserService extends IGeneralService<ImagePostUser> {

    Iterable<ImagePostUser> findAll();

    ImagePostUser[] listImage(Long postUser);

    Optional<ImagePostUser> findByPostUserId(Long postUserId);

    ImagePostUser findImageById(Long imageId);

}
