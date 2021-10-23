package com.amazetrip.api.controller;

import com.amazetrip.api.dao.CommentRepo;
import com.amazetrip.api.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/amazetrip/api")
public class CommentRestController {
    @Autowired
    private CommentRepo comRepo;

    @GetMapping("/comments")
    private Iterable<Comment> getAllComments(){
        return comRepo.findAll();
    }

}
