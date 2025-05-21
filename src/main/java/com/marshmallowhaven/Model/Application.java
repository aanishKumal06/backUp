package com.marshmallowhaven.Model;

import java.sql.Date;
import java.sql.Timestamp;

public class Application {

    private int applicationId;
    private String durationOfStay;
    private Date expectedCheckIn;
    private Date checkInDate;
    private Date checkOutDate;
    private String specialRequests;
    private String status;
    private String idProofDocumentUrl;
    private String photoUrl;
    private String medicalCertificateUrl;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Constructor (excluding applicationId, createdAt, and updatedAt as they're handled by DB)
    public Application(String durationOfStay, Date expectedCheckIn, String specialRequests, 
                     String photoUrl) {
        this.durationOfStay = durationOfStay;
        this.expectedCheckIn = expectedCheckIn;
        this.specialRequests = specialRequests;


        this.photoUrl = photoUrl;

    }

    // Getters and Setters



	public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getDurationOfStay() {
        return durationOfStay;
    }

    public void setDurationOfStay(String durationOfStay) {
        this.durationOfStay = durationOfStay;
    }

    public Date getExpectedCheckIn() {
        return expectedCheckIn;
    }

    public void setExpectedCheckIn(Date expectedCheckIn) {
        this.expectedCheckIn = expectedCheckIn;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdProofDocumentUrl() {
        return idProofDocumentUrl;
    }

    public void setIdProofDocumentUrl(String idProofDocumentUrl) {
        this.idProofDocumentUrl = idProofDocumentUrl;
    }


    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getMedicalCertificateUrl() {
        return medicalCertificateUrl;
    }

    public void setMedicalCertificateUrl(String medicalCertificateUrl) {
        this.medicalCertificateUrl = medicalCertificateUrl;
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
