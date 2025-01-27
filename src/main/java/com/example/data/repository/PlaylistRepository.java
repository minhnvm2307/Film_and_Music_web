package com.example.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.data.entity.PlaylistEntity;
import com.example.data.entity.SongEntity;

public interface PlaylistRepository extends JpaRepository<PlaylistEntity, Integer> {

    @Query("SELECT p FROM PlaylistEntity p " +
            "WHERE p.user_id = :userId ")
    public List<PlaylistEntity> findByUserId(@Param(value = "userId") Integer userId);

    @Query("SELECT s FROM SongEntity s " +
            "JOIN s.playlists p " +
            "WHERE p.playlist_id = :playlistId ")
    public List<SongEntity> findSongsByPlaylistId(@Param(value = "playlistId") Integer playlistId);
}
