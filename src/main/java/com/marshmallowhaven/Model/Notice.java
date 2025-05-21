package com.marshmallowhaven.Model;

public class Notice {
    private int noticeId;
    private String title;
    private String message;
    private String type;
    private java.sql.Timestamp createdAt;
    private java.sql.Timestamp updatedAt;

    // Constructor without ID (useful when inserting a new notification)
    public Notice(String title, String message, String type) {
        this.title = title;
        this.message = message;
        this.type = type;
    }

    // Constructor with all fields
    public Notice(int noticeId, String title, String message, String type, java.sql.Timestamp createdAt, java.sql.Timestamp updatedAt) {
        this.noticeId = noticeId;
        this.title = title;
        this.message = message;
        this.type = type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public int getnoticeId() {
        return noticeId;
    }

    public void setnoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public java.sql.Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(java.sql.Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
