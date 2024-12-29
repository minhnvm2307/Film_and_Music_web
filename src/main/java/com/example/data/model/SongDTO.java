package com.example.data.model;

import java.util.List;

public class SongDTO {
    private int songId;
    private String songName;
    private String songDescription;
    private String releaseDate;
    private String posterImg;
    private String audioLink;

    private List<CommentDTO> comments;
    private List<StarRatedDTO> ratings;
    private List<SingerDTO> singers;
    private List<CategoryDTO> categories;

    public SongDTO(int songId, String songName, String songDescription, String releaseDate, String posterImg, String audioLink, List<CommentDTO> comments, List<StarRatedDTO> ratings) {
        this.songId = songId;
        this.songName = songName;
        this.songDescription = songDescription;
        this.releaseDate = releaseDate;
        this.posterImg = posterImg;
        this.audioLink = audioLink;
        this.comments = comments;
        this.ratings = ratings;
    }

    public SongDTO() {
    }

    public List<SingerDTO> getSingers() {
        return singers;
    }

    public void setSingers(List<SingerDTO> singers) {
        this.singers = singers;
    }

    public List<StarRatedDTO> getRatings() {
        return ratings;
    }

    public void setRatings(List<StarRatedDTO> ratings) {
        this.ratings = ratings;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    public int getSongId() {
        return songId;
    }
    public void setSongId(int songId) {
        this.songId = songId;
    }
    public String getSongName() {
        return songName;
    }
    public void setSongName(String songName) {
        this.songName = songName;
    }
    public String getSongDescription() {
        return songDescription;
    }
    public void setSongDescription(String songDescription) {
        this.songDescription = songDescription;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getPosterImg() {
        return posterImg;
    }
    public void setPosterImg(String posterImg) {
        this.posterImg = posterImg;
    }
    public String getAudioLink() {
        return audioLink;
    }
    public void setAudioLink(String audioLink) {
        this.audioLink = audioLink;
    }

    
}
