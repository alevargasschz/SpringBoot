package com.example.demo.controller.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Comment;
import com.example.demo.service.ICommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/public/comments")
@RequiredArgsConstructor
public class CommentController {
    private final ICommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = commentService.findAll();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCommentById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(commentService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving comment: " + e.getMessage());
        }
    }
}
