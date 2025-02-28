package com.example.data.service;

import java.util.List;

import com.example.data.entity.*;
import com.example.data.model.CategoryDTO;

public interface CategoryService {
    // Get the list of Film Categories
    List<FilmCategoryEntity> findAll();

    List<CategoryDTO> findAllSongCategory();

    CategoryDTO findById(Integer categoryId);

//    List<SongCategoryEntity> findSongCategoryBySongId(Integer songId);
}
