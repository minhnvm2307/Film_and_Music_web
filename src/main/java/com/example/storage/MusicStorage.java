package com.example.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Component;

import com.example.data.model.SongDTO;
import com.example.data.model.converter.SongConverter;
import com.example.data.service.SongService;

@Component
public class MusicStorage {
    private SongDTO recentlyPlayedSong;
    private Stack<SongDTO> playlistSongs = new Stack<>();
    private SongService songService;
    private List<SongDTO> songs = new ArrayList<>();

    public MusicStorage(SongService songService) {
        this.songService = songService;
    }

    public SongDTO getNextSong(Integer songId) {
        songs = songService.getAllSongs();
        SongDTO nextSong = null;
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getSongId() == songId) {
                nextSong = songs.get((i + 1) % songs.size());
                break;
            }
        }
        return nextSong;
    }

    public SongDTO getPreviousSong() {
        SongDTO previousSong = this.playlistSongs.pop();
        return previousSong;
    }
    
    public void addToPlaylist(Integer songId) {
        SongDTO newSong = SongConverter.convertToDTO(songService.findByIdDefault(songId));
        playlistSongs.push(newSong);
    }

    public SongDTO getRecentlyPlayedSong() {
        return recentlyPlayedSong;
    }

    public void setRecentlyPlayedSong(Integer songId) {
        this.recentlyPlayedSong = SongConverter.convertToDTO(songService.findByIdDefault(songId));
    }

    public Stack<SongDTO> getPlaylistSongs() {
        return playlistSongs;
    }

}

