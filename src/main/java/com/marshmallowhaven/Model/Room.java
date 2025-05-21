package com.marshmallowhaven.Model;

import java.sql.Timestamp;

public class Room {
    private int roomId;
    private String roomNumber;
    private String roomType;
    private String roomDescription;
    private String roomFacilities;
    private int capacity;
    private int currentOccupancy;
    private int monthlyFee;
    private Boolean isAvailable;
    private String imageUrl;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String floor;
    private String roomStatus;


    // Full constructor
    public Room(int roomId, String roomNumber, String roomType, String roomDescription,
                String roomFacilities, int capacity, int currentOccupancy,
                int monthlyFee, Boolean isAvailable, String imageUrl,
                Timestamp createdAt, Timestamp updatedAt, String floor, String roomStatus) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomDescription = roomDescription;
        this.roomFacilities = roomFacilities;
        this.capacity = capacity;
        this.currentOccupancy = currentOccupancy;
        this.monthlyFee = monthlyFee;
        this.isAvailable = isAvailable;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.floor = floor;
        this.roomStatus = roomStatus;
    }
    
    public Room(String roomNumber, String roomType, String floor, int monthlyFee,
            String roomStatus, String roomFacilities, String imageUrl, String roomDescription, int capacity, Boolean isAvailable ) {
    this.roomNumber = roomNumber;
    this.roomType = roomType;
    this.floor = floor;
    this.monthlyFee = monthlyFee;
    this.roomStatus = roomStatus;
    this.roomFacilities = roomFacilities;
    this.imageUrl = imageUrl;
    this.roomDescription = roomDescription;
    this.capacity = capacity;
    this.isAvailable = isAvailable;
    }

    public Room(int currentOccupancy, boolean isAvailable, String roomStatus,  String roomType) {
        this.currentOccupancy = currentOccupancy;
        this.isAvailable = isAvailable;
        this.roomStatus = roomStatus;
        this.roomType = roomType;
    }




	// Getters and Setters
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public String getRoomFacilities() {
        return roomFacilities;
    }

    public void setRoomFacilities(String roomFacilities) {
        this.roomFacilities = roomFacilities;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentOccupancy() {
        return currentOccupancy;
    }

    public void setCurrentOccupancy(Integer currentOccupancy) {
        this.currentOccupancy = currentOccupancy;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(int monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    
}

