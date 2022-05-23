package com.codegym.module4casestudy.service.userInfo;

import com.codegym.module4casestudy.model.entity.UserInfo;
import com.codegym.module4casestudy.repository.IUserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService implements IUserInfoService {
    @Autowired
    private IUserInfoRepository userInfoRepository;

    @Override
    public Page<UserInfo> findAll(Pageable pageable) {
        return userInfoRepository.findAll(pageable);
    }

    @Override
    public Optional<UserInfo> findById(Long id) {
        return userInfoRepository.findById(id);
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    @Override
    public void deleteById(Long id) {
        userInfoRepository.deleteById(id);
    }

    @Override
    public Long findUserId(String email, String phone_number) {
        return userInfoRepository.findUserId(email, phone_number);
    }

    @Override
    public Optional<UserInfo> findByUserId(Long userId) {
        return userInfoRepository.findByUserId(userId);
    }

    @Override
    public List<UserInfo> showAllUserInfo(Long currentUserId) {
        return this.userInfoRepository.showAllUserInfo(currentUserId);
    }

    @Override
    public List<UserInfo> findAllUser() {
        return this.userInfoRepository.findAllUser();
    }

    @Override
    public List<UserInfo> findByFullNameContaining(String fullName) {
        return this.userInfoRepository.findByFullNameContaining("%" + fullName + "%");
    }
}
