package com.example.data.model;

import java.sql.Timestamp;

import com.example.data.entity.WebEnum;

public class CommentRequestDTO {
    private int userId;
    private int filmId;
    private int songId;
    private String commentText;
    private WebEnum type;
    private int parentCommentId;
    private Timestamp timeRated;

    // Getters and Setters

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public Timestamp getTimeRated() {
        return timeRated;
    }

    public void setTimeRated(Timestamp timeRated) {
        this.timeRated = timeRated;
    }

    public int getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(int parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public WebEnum getType() {
        return type;
    }

    public void setType(WebEnum type) {
        this.type = type;
    }
}

