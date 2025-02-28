package com.example.data.model;

import com.example.data.entity.WebEnum;

public class StarRatedDTO {
    private int starRatedId;
    private int ratingNumber;
    private int userId;
    private WebEnum type;
    
    public int getStarRatedId() {
        return starRatedId;
    }
    public void setStarRatedId(int starRatedId) {
        this.starRatedId = starRatedId;
    }
    public int getRatingNumber() {
        return ratingNumber;
    }
    public void setRatingNumber(int ratingNumber) {
        this.ratingNumber = ratingNumber;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public WebEnum getType() {
        return type;
    }
    public void setType(WebEnum type) {
        this.type = type;
    }

    // Getters and Setters
    
}
