package com.marshmallowhaven.Model;

import java.sql.Timestamp;

public class Complaint {

    private int complaintId;
    private String complaintType;
    private String description;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Constructor (excluding auto-generated and timestamp fields)
    public Complaint(String complaintType, String description) {
        this.complaintType = complaintType;
        this.description = description;
        
    }

    // Getters and Setters

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
