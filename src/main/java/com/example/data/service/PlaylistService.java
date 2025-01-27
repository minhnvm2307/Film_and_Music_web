package com.example.data.service;

import java.util.List;

import com.example.data.model.PlaylistDTO;
import com.example.data.model.SongDTO;

public interface PlaylistService {
    public List<PlaylistDTO> getAllPlaylist();

    public List<PlaylistDTO> getAllByUserId(Integer userId);

    public PlaylistDTO getPlaylistById(Integer playlistId);

    public List<SongDTO> getSongsByPlaylistId(Integer playlistId);

    public void savePlaylist(PlaylistDTO playlistDTO);

    public void deletePlaylist(Integer playlistId);

    public void addSongToPlaylist(Integer playlistId, Integer songId);
    
}
