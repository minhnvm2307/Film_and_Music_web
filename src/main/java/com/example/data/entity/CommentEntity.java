package com.example.data.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false)
    private int comment_id;

    @ManyToOne
    @JoinColumn(name = "parent_comment_id", nullable = true)
    private CommentEntity parentComment;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "comment_text", nullable = false)
    private String comment_text;

    @Column(name = "time_rated", nullable = false)
    private Timestamp time_rated;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private WebEnum type;

    @ManyToOne
    @JoinColumn(name = "film_id", nullable = true)
    @JsonIgnore
    private FilmEntity film;

    @ManyToOne
    @JoinColumn(name = "song_id", nullable = true)
    @JsonIgnore
    private SongEntity song;
    
    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<CommentEntity> childComments = new ArrayList<>();

    public SongEntity getSongEntity() {
        return song;
    }

    public void setSongEntity(SongEntity song) {
        this.song = song;
    }

    public int getComment_id() {
        return comment_id;
    }

    public CommentEntity getParentComment() {
        return parentComment;
    }

    public UserEntity getUser() {
        return user;
    }

    public String getComment_text() {
        return comment_text;
    }

    public Timestamp getTime_rated() {
        return time_rated;
    }

    public WebEnum getType() {
        return type;
    }

    public FilmEntity getFilm() {
        return film;
    }

    public List<CommentEntity> getChildComments() {
        return childComments;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public void setParentComment(CommentEntity parentComment) {
        this.parentComment = parentComment;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public void setTime_rated(Timestamp time_rated) {
        this.time_rated = time_rated;
    }

    public void setType(WebEnum type) {
        this.type = type;
    }

    public void setFilm(FilmEntity film) {
        this.film = film;
    }

    public void setChildComments(List<CommentEntity> childComments) {
        this.childComments = childComments;
    }

    
}