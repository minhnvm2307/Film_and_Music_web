package com.example.data.model;

import java.sql.Date;
import java.util.List;

import com.example.data.entity.FilmEntity;

public class FilmDTO {
    private int filmId;
    private String filmName;
    private String filmDescription;
    private String posterImg;
    private String status;
    private Date releaseDate;
    private String video;

    private List<CommentDTO> comments;
    private List<StarRatedDTO> ratings;
    private List<CategoryDTO> categories;
    private List<ActorDTO> actors;

    public FilmDTO(int filmId, String filmName, String filmDescription, String posterImg, String status, Date releaseDate, String video, List<CommentDTO> comments, List<StarRatedDTO> ratings, List<CategoryDTO> categories, List<ActorDTO> actors) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.filmDescription = filmDescription;
        this.posterImg = posterImg;
        this.status = status;
        this.releaseDate = releaseDate;
        this.video = video;
        this.comments = comments;
        this.ratings = ratings;
        this.categories = categories;
        this.actors = actors;
    }

    public FilmDTO(FilmEntity filmEntity) {
        this.filmId = filmEntity.getFilm_id();
        this.filmName = filmEntity.getFilm_name();
        this.filmDescription = filmEntity.getFilm_description();
        this.posterImg = filmEntity.getPoster_img();
        this.status = filmEntity.getStatus();
        this.releaseDate = filmEntity.getRelease_date();
        this.video = filmEntity.getVideo();
    }

    public List<ActorDTO> getActors() {
        return actors;
    }

    public void setActors(List<ActorDTO> actors) {
        this.actors = actors;
    }

    public int getFilmId() {
        return filmId;
    }
    public String getFilmName() {
        return filmName;
    }
    public String getFilmDescription() {
        return filmDescription;
    }
    public String getPosterImg() {
        return posterImg;
    }
    public String getStatus() {
        return status;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }
    public String getVideo() {
        return video;
    }
    public List<CommentDTO> getComments() {
        return comments;
    }
    public List<StarRatedDTO> getRatings() {
        return ratings;
    }
    public List<CategoryDTO> getCategories() {
        return categories;
    }
    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }
    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }
    public void setFilmDescription(String filmDescription) {
        this.filmDescription = filmDescription;
    }
    public void setPosterImg(String posterImg) {
        this.posterImg = posterImg;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    public void setVideo(String video) {
        this.video = video;
    }
    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }
    public void setRatings(List<StarRatedDTO> ratings) {
        this.ratings = ratings;
    }
    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    // Getters and Setters
    
}
