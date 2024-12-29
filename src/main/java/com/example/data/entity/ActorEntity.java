package com.example.data.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "actors")
public class ActorEntity {
    @Id
    @Column(name = "actor_id")
    private int actor_id;

    @Column(name = "actor_name")
    private String actor_name;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "country")
    private String country;

    @Column(name = "actor_description")
    private String actor_description;

    @Column(name = "avatar_img")
    private String avatar_img;

    @ManyToMany(mappedBy = "actors")
    @JsonIgnore
    private Set<FilmEntity> films = new HashSet<>();

    // Getters and Setters

    public int getActor_id() {
        return actor_id;
    }

    public String getActor_name() {
        return actor_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public String getCountry() {
        return country;
    }

    public String getActor_description() {
        return actor_description;
    }

    public String getAvatar_img() {
        return avatar_img;
    }

    public Set<FilmEntity> getFilms() {
        return films;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public void setActor_name(String actor_name) {
        this.actor_name = actor_name;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setActor_description(String actor_description) {
        this.actor_description = actor_description;
    }

    public void setAvatar_img(String avatar_img) {
        this.avatar_img = avatar_img;
    }

    public void setFilms(Set<FilmEntity> films) {
        this.films = films;
    }

    // Getters and Setters
    
}
