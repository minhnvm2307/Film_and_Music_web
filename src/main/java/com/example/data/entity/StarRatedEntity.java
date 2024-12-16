package com.example.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "star_rated")
public class StarRatedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "star_rated_id")
    private int starRatedId;

    @Column(name = "star_number")
    private int starNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private WebEnum type;

    @ManyToOne
    @JoinColumn(name = "film_id", nullable = true)
    @JsonIgnore
    private FilmEntity film;

    public int getStarRatedId() {
        return starRatedId;
    }

    public int getStarNumber() {
        return starNumber;
    }

    public String getType() {
        return type.toString();
    }

    public FilmEntity getFilm() {
        return film;
    }

    public void setStarRatedId(int starRatedId) {
        this.starRatedId = starRatedId;
    }

    public void setStarNumber(int starNumber) {
        this.starNumber = starNumber;
    }

    public void setType(WebEnum type) {
        this.type = type;
    }

    public void setFilm(FilmEntity film) {
        this.film = film;
    }
    
    
}
