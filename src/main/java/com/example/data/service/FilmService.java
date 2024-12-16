package com.example.data.service;

import java.util.List;

import com.example.data.entity.FilmEntity;
public interface FilmService {

    // Get the list of Films
    List<FilmEntity> findAll();

    // Get the list of Films with their ratings
    List<Object[]> getFilmsWithRatings();

    // Get the list of Films by category
    List<FilmEntity> getFilmsByCategory(Integer categoryId);
}