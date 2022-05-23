package com.codegym.module4casestudy.service.role;


import com.codegym.module4casestudy.model.entity.Role;
import com.codegym.module4casestudy.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Iterable<Role> findAll();
}
