package com.example.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.data.entity.SongCategoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SongCategoryRepository extends JpaRepository<SongCategoryEntity, Integer> {
}