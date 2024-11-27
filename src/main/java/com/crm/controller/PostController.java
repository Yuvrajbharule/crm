package com.crm.controller;


import com.crm.entity.Post;
import com.crm.service.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public String addPost(@RequestBody Post post)
    {

        postService.addPost(post);
        return "add post";
    }

    @DeleteMapping
    public String deletePost(@RequestParam long id) {

        postService.deletePost(id);


        return "delete post";

    }

}
