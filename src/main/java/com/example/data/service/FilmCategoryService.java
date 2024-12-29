package com.example.data.service;

import java.util.List;

import com.example.data.entity.*;

public interface FilmCategoryService {
    // Get the list of Film Categories
    List<FilmCategoryEntity> findAll();

    List<SongCategoryEntity> findAllSongCategory();
}
