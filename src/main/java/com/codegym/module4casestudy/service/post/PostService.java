package com.codegym.module4casestudy.service.post;

import com.codegym.module4casestudy.model.entity.PostUser;
import com.codegym.module4casestudy.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class PostService implements IPostService{

    @Autowired
    private IPostRepository postRepository;

    @Override
    public Page<PostUser> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Optional<PostUser> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public PostUser save(PostUser postUser) {
        return postRepository.save(postUser);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Iterable<PostUser> findAll() {
        return postRepository.findAll();
    }

    @Override
    public void deletePost(Long postUserId) {
        this.postRepository.deletePost(postUserId);
    }

    @Override
    public List<PostUser> showAllPostByUser(Long userInfoId) {
        return this.postRepository.showAllPostByUser(userInfoId);
    }

    @Override
    public String getDiffDays(Date time1, Date time2) {
        long timeDifferenceMilliseconds = (time2.getTime() - time1.getTime());
        long diffSeconds = timeDifferenceMilliseconds / 1000;
        long diffMinutes = timeDifferenceMilliseconds / (60 * 1000);
        long diffHours = timeDifferenceMilliseconds / (60 * 60 * 1000);
        long diffDays = timeDifferenceMilliseconds / (60 * 60 * 1000 * 24);
        long diffWeeks = timeDifferenceMilliseconds / (60 * 60 * 1000 * 24 * 7);
        long diffMonths = (long) (timeDifferenceMilliseconds / (60 * 60 * 1000 * 24 * 30.41666666));
        long diffYears = timeDifferenceMilliseconds / ((long)60 * 60 * 1000 * 24 * 365);

        if (diffSeconds < 1) {
            return "v???a xong";
        } else if (diffMinutes < 1) {
            return diffSeconds + " gi??y";
        } else if (diffHours < 1) {
            return diffMinutes + " ph??t";
        } else if (diffDays < 1) {
            return diffHours + " gi???";
        } else if (diffWeeks < 1) {
            return diffDays + " ng??y";
        } else if (diffMonths < 1) {
            return diffWeeks + " tu???n";
        } else if (diffYears < 1) {
            return diffMonths + " th??ng";
        } else {
            return diffYears + " n??m";
        }
    }

    @Override
    public List<PostUser> postUserFriends(Long userId) {
        return postRepository.postUserFriends(userId);
    }
}

