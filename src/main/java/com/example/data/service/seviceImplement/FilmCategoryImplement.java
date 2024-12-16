package com.example.data.service.seviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.repository.FilmCategoryRepository;
import com.example.data.entity.FilmCategoryEntity;
import com.example.data.service.FilmCategoryService;

import java.util.List;

@Service
public class FilmCategoryImplement implements FilmCategoryService {

    @Autowired
    private FilmCategoryRepository filmCategoryRepository;

    public List<FilmCategoryEntity> findAll() {
        return filmCategoryRepository.findAll();
    }
    
}
