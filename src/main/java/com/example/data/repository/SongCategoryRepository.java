package com.example.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.data.entity.SongCategoryEntity;

public interface SongCategoryRepository extends JpaRepository<SongCategoryEntity, Integer> {
}