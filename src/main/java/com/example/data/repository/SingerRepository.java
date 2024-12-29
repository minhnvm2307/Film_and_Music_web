package com.example.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.data.entity.SingerEntity;

@Repository
public interface SingerRepository extends JpaRepository<SingerEntity, Integer> {

    @Query("SELECT s.singer_id AS singerId, s.singer_name AS singerName, s.date_of_birth AS dateOfBirth, s.country AS country, s.singer_description AS singerDescription, s.avatar_img AS avatarImg " +
           "FROM SingerEntity s " +
           "JOIN s.songs ss " +
           "WHERE ss.song_id = :songId")
    public List<SingerEntity> findBySongId(@Param("songId") Integer songId);
}
