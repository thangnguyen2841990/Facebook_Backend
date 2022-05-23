package com.codegym.module4casestudy.controller;

import com.codegym.module4casestudy.model.entity.ImagePostUser;
import com.codegym.module4casestudy.repository.IImagePostUserRepository;
import com.codegym.module4casestudy.service.imagePostUser.IImagePostUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/images")
public class ImagePostUserRepository {

    @Autowired
    private IImagePostUserService imagePostUserService;

    @GetMapping("/{imageId}")
    public ResponseEntity<ImagePostUser> findById(@PathVariable Long imageId) {
       ImagePostUser image = this.imagePostUserService.findImageById(imageId);
       return new ResponseEntity<>(image, HttpStatus.OK);
    }
    @GetMapping("/all/{postId}")
    public ResponseEntity<ImagePostUser[]> findAllImages(@PathVariable Long postId) {
       ImagePostUser[] images = this.imagePostUserService.listImage(postId);
       return new ResponseEntity<>(images, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ImagePostUser> deleteImgById(@PathVariable Long id) {
        this.imagePostUserService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
