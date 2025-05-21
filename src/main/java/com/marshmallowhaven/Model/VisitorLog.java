package com.marshmallowhaven.Model;

public class VisitorLog {
    private int logId;
    private String visitorName;
    private String visitorIdNumber;
    private String relationship;
    private java.sql.Timestamp checkInTime;
    private java.sql.Timestamp checkOutTime;
    private String purpose;
    private java.sql.Timestamp createdAt;

    // Constructor without ID (for new entries)
    public VisitorLog(String visitorName, String visitorIdNumber, String relationship,
                      java.sql.Timestamp checkInTime, java.sql.Timestamp checkOutTime, String purpose) {
        this.visitorName = visitorName;
        this.visitorIdNumber = visitorIdNumber;
        this.relationship = relationship;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.purpose = purpose;
    }

    // Constructor with all fields
    public VisitorLog(int logId, String visitorName, String visitorIdNumber, String relationship,
                      java.sql.Timestamp checkInTime, java.sql.Timestamp checkOutTime,
                      String purpose, java.sql.Timestamp createdAt) {
        this.logId = logId;
        this.visitorName = visitorName;
        this.visitorIdNumber = visitorIdNumber;
        this.relationship = relationship;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.purpose = purpose;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorIdNumber() {
        return visitorIdNumber;
    }

    public void setVisitorIdNumber(String visitorIdNumber) {
        this.visitorIdNumber = visitorIdNumber;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public java.sql.Timestamp getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(java.sql.Timestamp checkInTime) {
        this.checkInTime = checkInTime;
    }

    public java.sql.Timestamp getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(java.sql.Timestamp checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
