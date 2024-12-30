package com.example.data.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "songs")
public class SongEntity {
    @Id
    @Column(name = "song_id")
    private int song_id;

    @Column(name = "song_name")
    private String song_name;

    @Column(name = "song_description")
    private String song_description;

    @Column(name = "release_date")
    private Date release_date;

    @Column(name = "poster_img")
    private String poster_img;

    @Column(name = "audio_link")
    private String audio_link;

    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StarRatedEntity> starRatings = new ArrayList<>();

    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommentEntity> comments = new ArrayList<>();

     @ManyToMany
     @JoinTable(
         name = "song_category",
         joinColumns = @JoinColumn(name = "song_id"),
         inverseJoinColumns = @JoinColumn(name = "category_id")
     )
     private List<SongCategoryEntity> categories = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "song_singer",
        joinColumns = @JoinColumn(name = "song_id"),
        inverseJoinColumns = @JoinColumn(name = "singer_id")
    )
    private List<SingerEntity> singers = new ArrayList<>();

    public List<SongCategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<SongCategoryEntity> categories) {
        this.categories = categories;
    }

    public List<SingerEntity> getSingers() {
        return singers;
    }

    public void setSingers(List<SingerEntity> singers) {
        this.singers = singers;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getSong_description() {
        return song_description;
    }

    public void setSong_description(String song_description) {
        this.song_description = song_description;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getPoster_img() {
        return poster_img;
    }

    public void setPoster_img(String poster_img) {
        this.poster_img = poster_img;
    }

    public String getAudio_link() {
        return audio_link;
    }

    public void setAudio_link(String audio_link) {
        this.audio_link = audio_link;
    }

    public List<StarRatedEntity> getStarRatings() {
        return starRatings;
    }

    public void setStarRatings(List<StarRatedEntity> starRatings) {
        this.starRatings = starRatings;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }    
}
