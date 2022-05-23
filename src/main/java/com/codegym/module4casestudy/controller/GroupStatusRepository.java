package com.codegym.module4casestudy.controller;

import com.codegym.module4casestudy.model.entity.GroupStatus;
import com.codegym.module4casestudy.service.groupStatus.IGroupStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/groupStatus")
public class GroupStatusRepository {
    @Autowired
    private IGroupStatusService groupStatusService;

    @GetMapping
    public ResponseEntity<List<GroupStatus>> findAll() {
        List<GroupStatus> listStatus = this.groupStatusService.findAll();
        return new ResponseEntity<>(listStatus, HttpStatus.OK);
    }
}
