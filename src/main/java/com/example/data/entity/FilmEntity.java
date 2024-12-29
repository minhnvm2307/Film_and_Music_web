package com.example.data.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "films")
public class FilmEntity {
    @Id
    @Column(name = "film_id")
    private int film_id;

    @Column(name = "film_name")
    private String film_name;

    @Column(name = "film_description")
    private String film_description;

    @Column(name = "poster_img")
    private String poster_img;

    @Column(name = "status")
    private String status;

    @Column(name = "release_date")
    private Date release_date;

    @Column(name = "video")
    private String video;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StarRatedEntity> starRatings = new ArrayList<>();

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommentEntity> comments = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "film_category",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<FilmCategoryEntity> categories = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "film_actor",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<ActorEntity> actors = new ArrayList<>();




    
    // Getters and Setters
    public List<ActorEntity> getActors() {
        return new ArrayList<>(actors);
    }

    public void setActors(List<ActorEntity> actors) {
        this.actors = actors;
    }

    public List<FilmCategoryEntity> getCategories() {
        return new ArrayList<>(categories);
    }

    public void setCategories(List<FilmCategoryEntity> categories) {
        this.categories = categories;
    }

    public List<StarRatedEntity> getStarRatings() {
        return new ArrayList<>(starRatings);
    }

    public void setStarRatings(List<StarRatedEntity> starRatings) {
        this.starRatings = starRatings;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    public String getFilm_description() {
        return film_description;
    }

    public void setFilm_description(String film_description) {
        this.film_description = film_description;
    }

    public String getPoster_img() {
        return poster_img;
    }

    public void setPoster_img(String poster_img) {
        this.poster_img = poster_img;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmEntity that = (FilmEntity) o;
        return film_id == that.film_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(film_id);
    }
}
