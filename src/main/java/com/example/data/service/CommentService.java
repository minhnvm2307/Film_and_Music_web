package com.example.data.service;

import java.util.List;

import com.example.data.entity.CommentEntity;

public interface CommentService {
    List<CommentEntity> getCommentsByFilmId(Integer filmId);

    List<CommentEntity> getCommentsBySongId(Integer songId);

    List<CommentEntity> getTopLevelCommentsByFilmId(Integer filmId);

    List<CommentEntity> getTopLevelCommentsBySongId(Integer songId);

    CommentEntity saveComment(CommentEntity comment);

    CommentEntity getCommentById(Integer commentId);

    List<CommentEntity> getCommentsByParentCommentId(Integer parentCommentId);
}
