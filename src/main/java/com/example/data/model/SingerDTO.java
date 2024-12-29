package com.example.data.model;

public class SingerDTO {
    Integer singerId;
    String singerName;
    String dateOfBirth;
    String country;
    String description;
    String avatarImg;

    public SingerDTO() {
    }

    public SingerDTO(Integer singerId, String singerName, String dateOfBirth, String country, String description,
            String avatarImg) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.description = description;
        this.avatarImg = avatarImg;
    }

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String city) {
        this.description = city;
    }

    public String getAvatarImg() {
        return avatarImg;
    }

    public void setAvatarImg(String avatarImg) {
        this.avatarImg = avatarImg;
    }

}
