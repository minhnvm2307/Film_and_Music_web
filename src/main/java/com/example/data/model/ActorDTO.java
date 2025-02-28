package com.example.data.model;

import java.sql.Date;

public class ActorDTO {
    private int actorId;
    private String actorName;
    private Date actorBirthDate;
    private String actorDescription;
    private String actorImg;

    

    public int getActorId() {
        return actorId;
    }
    public String getActorName() {
        return actorName;
    }
    public Date getActorBirthDate() {
        return actorBirthDate;
    }
    public String getActorDescription() {
        return actorDescription;
    }
    public String getActorImg() {
        return actorImg;
    }
    public void setActorId(int actorId) {
        this.actorId = actorId;
    }
    public void setActorName(String actorName) {
        this.actorName = actorName;
    }
    public void setActorBirthDate(Date actorBirthDate) {
        this.actorBirthDate = actorBirthDate;
    }
    public void setActorDescription(String actorDescription) {
        this.actorDescription = actorDescription;
    }
    public void setActorImg(String actorImg) {
        this.actorImg = actorImg;
    }

    // Getters and Setters
    
    
}
