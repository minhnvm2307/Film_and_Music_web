package com.example.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.data.entity.FilmCategoryEntity;

public interface FilmCategoryRepository extends JpaRepository<FilmCategoryEntity, Integer> {
    List<FilmCategoryEntity> findAll();
}
