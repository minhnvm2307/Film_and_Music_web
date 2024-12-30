package com.example.data.service.seviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.entity.CommentEntity;
import com.example.data.repository.CommentRepository;
import com.example.data.service.CommentService;

@Service
public class CommentServiceImplement implements CommentService {
    
    @Autowired
    private CommentRepository commentRepository;

    public List<CommentEntity> getCommentsByFilmId(Integer filmId) {
        return commentRepository.getCommentsByFilmId(filmId);
    }

    public List<CommentEntity> getCommentsBySongId(Integer songId) {
        return commentRepository.getCommentsBySongId(songId);
    }

    public List<CommentEntity> getTopLevelCommentsByFilmId(Integer filmId) {
        return commentRepository.getTopLevelCommentsByFilmId(filmId);
    }

    public List<CommentEntity> getTopLevelCommentsBySongId(Integer songId) {
        return commentRepository.getTopLevelCommentsBySongId(songId);
    }

    public CommentEntity saveComment(CommentEntity comment) {
        return commentRepository.save(comment);
    }
    
    public CommentEntity getCommentById(Integer commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public List<CommentEntity> getCommentsByParentCommentId(Integer parentCommentId) {
        return commentRepository.findByParentCommentId(parentCommentId);
    }
}
