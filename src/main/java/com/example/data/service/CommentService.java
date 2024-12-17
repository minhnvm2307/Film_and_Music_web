package com.example.data.service;

import java.util.List;

import com.example.data.entity.CommentEntity;

public interface CommentService {
    List<CommentEntity> getCommentsByFilmId(Integer filmId);

    List<CommentEntity> getTopLevelCommentsByFilmId(Integer filmId);

    CommentEntity saveComment(CommentEntity comment);

    CommentEntity getCommentById(Integer commentId);
}
