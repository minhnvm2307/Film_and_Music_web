package com.example.data.service;

import java.util.List;

import com.example.data.model.CategoryDTO;
import com.example.data.model.SongDTO;

public interface SongService {
    public List<SongDTO> getAllSongs();

    public Object getSongById(int songId);

    public List<SongDTO> getSongByCategoryName(String categoryName);

    public CategoryDTO getCategoryById(Integer categoryId);

    public void addSong(SongDTO song);

    public void updateSong(SongDTO song);

    public void deleteSong(int songId);
}
