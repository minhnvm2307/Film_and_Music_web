package com.example.data.service;

import java.util.List;

import com.example.data.model.SongDTO;

public interface SongService {
    public List<SongDTO> getAllSongs();

    public Object getSongById(int songId);
}
