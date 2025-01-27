package com.example.data.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "playlists")
public class PlaylistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_id")    
    private Integer playlist_id;

    @Column(name = "playlist_name")
    private String playlist_name;

    @Column(name = "user_id")
    private Integer user_id;

    @ManyToMany(mappedBy = "playlists")
    @JsonIgnore
    private Set<SongEntity> songs = new HashSet<>();

    public Integer getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(Integer playlist_id) {
        this.playlist_id = playlist_id;
    }

    public String getPlaylist_name() {
        return playlist_name;
    }

    public void setPlaylist_name(String playlist_name) {
        this.playlist_name = playlist_name;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Set<SongEntity> getSongs() {
        return songs;
    }

    public void setSongs(Set<SongEntity> songs) {
        this.songs = songs;
    }

    
}
