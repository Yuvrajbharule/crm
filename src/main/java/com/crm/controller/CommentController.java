package com.crm.controller;


import com.crm.entity.Comment;
import com.crm.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/comment")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public String addComment(@RequestBody Comment comment, @RequestParam long id)
    {

        commentService.addComment(comment, id);
        return "Add a new comment";
    }

}
