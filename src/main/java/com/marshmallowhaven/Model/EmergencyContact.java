package com.marshmallowhaven.Model;

public class EmergencyContact {
    private int emergencyId;
    private String name;
    private String relationship;
    private String phoneNumber;
    private String email;
    private java.sql.Timestamp createdAt;
    private java.sql.Timestamp updatedAt;

    // Constructor without ID (for insertion before auto-generation)
    public EmergencyContact(String name, String relationship, String phoneNumber, String email) {
        this.name = name;
        this.relationship = relationship;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Constructor with all fields
    public EmergencyContact(int emergencyId, String name, String relationship, String phoneNumber, String email, java.sql.Timestamp createdAt, java.sql.Timestamp updatedAt) {
        this.emergencyId = emergencyId;
        this.name = name;
        this.relationship = relationship;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public int getEmergencyId() {
        return emergencyId;
    }

    public void setEmergencyId(int emergencyId) {
        this.emergencyId = emergencyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
