package com.crm.service;

import com.crm.entity.Comment;
import com.crm.entity.Post;
import com.crm.repository.CommentRepository;
import com.crm.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public void addComment(Comment comment, long id) {

        Post post  = postRepository.findById(id).get();

        comment.setPost(post);

        commentRepository.save(comment);



    }
}
