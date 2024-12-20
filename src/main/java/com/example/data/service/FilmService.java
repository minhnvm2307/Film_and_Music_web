package com.example.data.service;

import java.util.List;
import com.example.data.entity.FilmEntity;
import com.example.data.entity.StarRatedEntity;

public interface FilmService {

    // Get the list of Films
    List<FilmEntity> findAll();

    // Get film by id
    FilmEntity findById(int id);

    // Get the list of Films with their ratings
    List<Object[]> getFilmsWithRatings();

    // Get the list of Films by category
    List<FilmEntity> getFilmsByCategory(Integer categoryId);

    // Get the Film with rating by id
    Object getFilmById(Integer id);

    // Get the Film default
    FilmEntity getFilmByIdDefault(Integer id);

    // Rate the Film
    StarRatedEntity rateFilm(Integer filmId, Integer userId, Integer rating);
}