package com.example.data.model;

import java.sql.Date;

import com.example.data.entity.WebEnum;

public class CommentDTO {
    private int commentId;
    private String commentText;
    private Date commentDate;
    private WebEnum type;
    
    public int getCommentId() {
        return commentId;
    }
    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }
    public String getCommentText() {
        return commentText;
    }
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
    public Date getCommentDate() {
        return commentDate;
    }
    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
    public WebEnum getType() {
        return type;
    }
    public void setType(WebEnum type) {
        this.type = type;
    }

    // Getters and Setters
    
}