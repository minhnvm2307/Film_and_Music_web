package com.example.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.data.entity.FilmEntity;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {

    @Query("SELECT fe.film_id, fe.film_name, fe.poster_img, fe.release_date, COALESCE(AVG(s.starNumber), 0) AS avgRating, fe.video " +
           "FROM FilmEntity fe LEFT JOIN fe.starRatings s " +
           "WHERE s.type = 'film' OR s.type IS NULL " +
           "GROUP BY fe.film_id")
    List<Object[]> getFilmsWithRatings();

    @Query("SELECT f FROM FilmEntity f " +
           "JOIN FETCH f.categories c " +
           "WHERE c.categoryId = :categoryId")
    List<FilmEntity> findFilmsByCategoryId(@Param("categoryId") Integer categoryId);
}
