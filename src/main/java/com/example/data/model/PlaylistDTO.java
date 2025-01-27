package com.example.data.model;

public class PlaylistDTO {
    private Integer playlistId;
    private String playlistName;
    private Integer userId;
    private String username;

    public PlaylistDTO() {}

    public PlaylistDTO(Integer playlistId, String playlistName, Integer userId) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.userId = userId;
    }

    public Integer getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Integer playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
}
