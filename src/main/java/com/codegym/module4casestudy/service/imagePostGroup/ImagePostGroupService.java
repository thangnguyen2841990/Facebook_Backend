package com.codegym.module4casestudy.service.imagePostGroup;

import com.codegym.module4casestudy.model.entity.ImagePostGroup;
import com.codegym.module4casestudy.repository.IImagePostGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImagePostGroupService implements IImagePostGroupService{
    @Autowired
    private IImagePostGroup iImagePostGroup;
    @Override
    public Page<ImagePostGroup> findAll(Pageable pageable) {
        return iImagePostGroup.findAll(pageable);
    }

    @Override
    public Optional<ImagePostGroup> findById(Long id) {
        return iImagePostGroup.findById(id);
    }

    @Override
    public ImagePostGroup save(ImagePostGroup imagePostGroup) {
        return iImagePostGroup.save(imagePostGroup);
    }

    @Override
    public void deleteById(Long id) {
        iImagePostGroup.deleteById(id);
    }

    @Override
    public ImagePostGroup[] listImage(Long postGroupId) {
        return this.iImagePostGroup.listImage(postGroupId);
    }
}
