package com.example.data.repository;

import com.example.data.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<SongEntity, Integer> {

    @Query("SELECT s.song_id AS songId, s.song_name AS songName, s.song_description AS songDescription, s.release_date AS releaseDate, s.poster_img AS posterImg, s.audio_link AS audioLink, " +
           "COALESCE(AVG(sr.starNumber), 0) AS avgRating " +
           "FROM SongEntity s " +
           "LEFT JOIN s.starRatings sr ON sr.song.song_id = s.song_id AND sr.type = 'song' " +
           "WHERE s.song_id = :songId " +
           "GROUP BY s.song_id")
    Object findBySongId(@Param("songId") Integer songId);

    @Query("SELECT s.song_id AS songId, s.song_name AS songName, s.song_description AS songDescription, s.release_date AS releaseDate, s.poster_img AS posterImg, s.audio_link AS audioLink " +
           "FROM SongEntity s " +
           "Left JOIN s.categories c " +
           "WHERE c.categoryName = :categoryName")
    List<SongEntity> findSongByCategoryName(@Param("categoryName") String categoryName);
}
