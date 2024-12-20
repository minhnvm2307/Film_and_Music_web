package com.example.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.data.entity.StarRatedEntity;

@Repository
public interface StarRatedRepository extends JpaRepository<StarRatedEntity, Integer> {
    @Query("SELECT s FROM StarRatedEntity s WHERE s.user_id = :userID")
    StarRatedEntity findByUserID(@Param("userID") int userID);
    
}
