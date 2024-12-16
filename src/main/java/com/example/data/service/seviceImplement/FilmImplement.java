package com.example.data.service.seviceImplement;

import org.springframework.stereotype.Service;
import com.example.data.entity.FilmEntity;
import com.example.data.repository.FilmRepository;
import com.example.data.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class FilmImplement implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    // Add the implementation of the FilmService interface here
    public List<FilmEntity> findAll() {
        return filmRepository.findAll();
    }

    public List<Object[]> getFilmsWithRatings() {
        return filmRepository.getFilmsWithRatings();
    }

    public List<FilmEntity> getFilmsByCategory(Integer categoryId) {
        return filmRepository.findFilmsByCategoryId(categoryId);
    }
}
