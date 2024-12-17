package com.example.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.data.entity.CommentEntity;
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


    @Query("SELECT fe.film_id AS filmId, fe.film_name AS filmName, fe.poster_img AS posterImg, fe.release_date AS releaseDate, fe.film_description AS filmDescription," +
       "COALESCE(AVG(s.starNumber), 0) AS avgRating, fe.video AS video " +
       "FROM FilmEntity fe " +
       "LEFT JOIN fe.starRatings s ON s.film.film_id = fe.film_id AND s.type = 'film' " +
       "WHERE fe.film_id = :filmId " +
       "GROUP BY fe.film_id")
    Object getFilmById(@Param("filmId") Integer filmId);
}
