package com.example.storage;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.data.model.SongDTO;
import com.example.data.model.converter.SongConverter;
import com.example.data.service.SongService;

@Component
public class MusicStorage {
    private SongDTO recentlyPlayedSong;
    private LocalTime pauseTime;
    private Stack<SongDTO> playlistSongs = new Stack<>();
    private final SongService songService;

    public MusicStorage(SongService songService) {
        this.songService = songService;
    }

    public SongDTO getRecentlyPlayedSong() {
        return recentlyPlayedSong;
    }

    public void setRecentlyPlayedSong(Integer songId, LocalTime time) {
        this.recentlyPlayedSong = SongConverter.convertToDTO(songService.findByIdDefault(songId));
        this.pauseTime = time;
    }

    public List<SongDTO> getPlaylistSongs() {
        return playlistSongs;
    }

    public void addToPlaylist(Integer songId) {
        SongDTO newSong = SongConverter.convertToDTO(songService.findByIdDefault(songId));
        playlistSongs.push(newSong);
    }

    public LocalTime getPauseTime() {
        return pauseTime;
    }
}

