package com.codegym.module4casestudy.service.imagePostGroup;

import com.codegym.module4casestudy.model.entity.ImagePostGroup;
import com.codegym.module4casestudy.service.IGeneralService;

public interface IImagePostGroupService extends IGeneralService<ImagePostGroup> {
    ImagePostGroup[] listImage(Long postGroupId);

}
