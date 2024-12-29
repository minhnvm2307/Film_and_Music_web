package com.example.data.service.seviceImplement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.data.entity.FilmEntity;
import com.example.data.entity.StarRatedEntity;
import com.example.data.entity.WebEnum;
import com.example.data.model.FilmDTO;
import com.example.data.model.converter.FilmConverter;
import com.example.data.repository.FilmRepository;
import com.example.data.repository.StarRatedRepository;
import com.example.data.service.FilmService;

@Service
public class FilmImplement implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired StarRatedRepository starRatedRepository;

    // Add the implementation of the FilmService interface here
    public List<FilmEntity> findAll() {
        return filmRepository.findAll();
    }

    public FilmEntity findById(int id) {
        return filmRepository.findById(id).orElse(null);
    }

    public List<Object[]> getFilmsWithRatings() {
        return filmRepository.getFilmsWithRatings();
    }

    @Transactional(readOnly = true)
    @Override
    public List<FilmDTO> getFilmsByCategory(Integer categoryId) {
        List<FilmEntity> filmEntities = filmRepository.findFilmsByCategoryId(categoryId);
        
        return FilmConverter.convertFromEntityList(filmEntities);
    }

    public Object getFilmById(Integer id) {
        return filmRepository.getFilmById(id);
    }

    public FilmEntity getFilmByIdDefault(Integer id) {
        return filmRepository.findById(id).orElse(null);
    }

    public StarRatedEntity rateFilm(Integer filmId, Integer userId, Integer rating) {
        // Check if the user has already rated the film
        StarRatedEntity existingRating = starRatedRepository.findByUserIDAndFilmID(userId, filmId);

        FilmEntity film = filmRepository.findById(filmId).orElse(null);
        StarRatedEntity newRating = new StarRatedEntity();
        newRating.setFilm(film);
        newRating.setUser_id(userId);
        newRating.setStarNumber(rating);
        newRating.setType(WebEnum.film);
        newRating.setSong(null);

        if (existingRating != null) {
            newRating.setStarRatedId(existingRating.getStarRatedId());
        }
        
        return starRatedRepository.save(newRating);
    }

    public StarRatedEntity getRatingByUser(Integer filmId, Integer userId) {
        return starRatedRepository.findByUserIDAndFilmID(userId, filmId);
    }
    
}
