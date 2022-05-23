package com.codegym.module4casestudy.service.groupStatus;

import com.codegym.module4casestudy.model.entity.GroupStatus;
import com.codegym.module4casestudy.repository.IGroupStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupStatusService implements IGroupStatusService {
    @Autowired
    private IGroupStatusRepository groupStatusRepository;

    @Override
    public Page<GroupStatus> findAll(Pageable pageable) {
        return groupStatusRepository.findAll(pageable);
    }

    @Override
    public Optional<GroupStatus> findById(Long id) {
        return groupStatusRepository.findById(id);
    }

    @Override
    public GroupStatus save(GroupStatus groupStatus) {
        return groupStatusRepository.save(groupStatus);
    }

    @Override
    public void deleteById(Long id) {
        groupStatusRepository.deleteById(id);
    }

    @Override
    public List<GroupStatus> findAll() {
        return groupStatusRepository.findAll();
    }
}
