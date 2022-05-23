package com.codegym.module4casestudy.controller;

import com.codegym.module4casestudy.model.entity.StatusPost;
import com.codegym.module4casestudy.service.statusPost.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/status")
public class StatusController {
    @Autowired
    private IStatusService statusService;

    @GetMapping
    public ResponseEntity<List<StatusPost>> findAll() {
        List<StatusPost> statusPostList = this.statusService.findAll();
        return new ResponseEntity<>(statusPostList, HttpStatus.OK);
    }
}
