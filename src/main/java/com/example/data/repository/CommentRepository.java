package com.example.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.data.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    
    @Query("SELECT c FROM CommentEntity c WHERE c.film.film_id = :filmId AND c.type = 'film' ORDER BY c.time_rated DESC")
    List<CommentEntity> getCommentsByFilmId(@Param("filmId") Integer filmId);

    @Query("SELECT c FROM CommentEntity c WHERE c.song.song_id = :songId AND c.type = 'song' ORDER BY c.time_rated DESC")
    List<CommentEntity> getCommentsBySongId(@Param("songId") Integer songId);

    @Query("SELECT c FROM CommentEntity c LEFT JOIN FETCH c.childComments WHERE c.film.film_id = :filmId AND c.parentComment IS NULL ORDER BY c.time_rated DESC")
    List<CommentEntity> getTopLevelCommentsByFilmId(@Param("filmId") Integer filmId);

    @Query("SELECT c FROM CommentEntity c WHERE c.song.song_id = :songId AND c.parentComment IS NULL ORDER BY c.time_rated DESC")
    List<CommentEntity> getTopLevelCommentsBySongId(@Param("songId") Integer songId);

    @Query("SELECT c FROM CommentEntity c WHERE c.parentComment.comment_id = :parentCommentId ORDER BY c.time_rated DESC")
    List<CommentEntity> findByParentCommentId(@Param("parentCommentId") Integer parentCommentId);
}
