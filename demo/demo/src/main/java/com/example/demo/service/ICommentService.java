package com.example.demo.service;


import java.sql.Timestamp;
import java.util.List;

import com.example.demo.model.Comment;


public interface ICommentService {
    List<Comment> findByCreatedAtBetween (Timestamp startDate, Timestamp endDate);
}
