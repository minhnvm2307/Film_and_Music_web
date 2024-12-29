package com.example.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.data.entity.ActorEntity;

@Repository
public interface ActorRepository extends JpaRepository<ActorEntity, Integer> {
    @Query("SELECT a FROM ActorEntity a " +
            "JOIN a.films f " +
            "WHERE f.film_id = :filmId")
    List<ActorEntity> findByFilmId(@Param("filmId") Integer filmId);    
}
