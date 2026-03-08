package com.example.demo.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Comment;
import com.example.demo.repository.ICommentRepository;
import com.example.demo.service.ICommentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements ICommentService {
    private final ICommentRepository commentRepository;

    @Override
    public List<Comment> findByCreatedAtBetween(Timestamp startDate, Timestamp endDate) {
        return commentRepository.findByCreatedAtBetween(startDate, endDate);
    }

}
