package com.example.data.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "singers")
public class SingerEntity {
    @Id
    @Column(name = "singer_id")
    private Integer singer_id;

    @Column(name = "name")
    private String singer_name;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "country")
    private String country;

    @Column(name = "singer_description")
    private String singer_description;

    @Column(name = "avatar_img")
    private String avatar_img;

    @ManyToMany(mappedBy = "singers", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<SongEntity> songs = new HashSet<>();

    public Integer getSinger_id() {
        return singer_id;
    }

    public void setSinger_id(Integer singer_id) {
        this.singer_id = singer_id;
    }

    public String getSinger_name() {
        return singer_name;
    }

    public void setSinger_name(String singer_name) {
        this.singer_name = singer_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSinger_description() {
        return singer_description;
    }

    public void setSinger_description(String city) {
        this.singer_description = city;
    }

    public String getAvatar_img() {
        return avatar_img;
    }

    public void setAvatar_img(String avatar_img) {
        this.avatar_img = avatar_img;
    }

    public Set<SongEntity> getSongs() {
        return songs;
    }

    public void setSongs(Set<SongEntity> songs) {
        this.songs = songs;
    }

    // Getters and Setters

}
