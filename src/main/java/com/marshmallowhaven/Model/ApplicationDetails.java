package com.marshmallowhaven.Model;

import java.sql.Date;
import java.sql.Timestamp;

public class ApplicationDetails {
    private int applicationUserId;
    private String fullName;
    private int userId;
    private String email;
    private String gender;
    private Date dateOfBirth;
    private String contactNumber;
    private String address;
    private String roomNumber;
    private String roomType;
    private String roomfloor;
    private int monthlyFee;
    private int currentOccupancy;
    private int applicationId;
    private String durationOfStay;
    private Date expectedCheckIn;
    private Date checkOutDate;
    private String specialRequests;
    private String status;
    private String photoUrl;
    private Timestamp applicationCreatedAt;

    




	public ApplicationDetails(int applicationUserId, String fullName, int userId, String email, String gender,
			            Date dateOfBirth, String contactNumber, String address, String roomNumber,
			            String roomType, int currentOccupancy, int applicationId, String durationOfStay, Date expectedCheckIn,
			            Date checkOutDate, String specialRequests, String status, String photoUrl,
			            Timestamp applicationCreatedAt) {
			this.applicationUserId = applicationUserId;
			this.fullName = fullName;
			this.userId = userId;
			this.email = email;
			this.gender = gender;
			this.dateOfBirth = dateOfBirth;
			this.contactNumber = contactNumber;
			this.address = address;
			this.roomNumber = roomNumber;
			this.roomType = roomType;
			this.currentOccupancy = currentOccupancy;
			this.applicationId = applicationId;
			this.durationOfStay = durationOfStay;
			this.expectedCheckIn = expectedCheckIn;
			this.checkOutDate = checkOutDate;
			this.specialRequests = specialRequests;
			this.status = status;
			this.photoUrl = photoUrl;
			this.applicationCreatedAt = applicationCreatedAt;
			}
    
    


    
    // Getters and Setters

    public int getMonthlyFee() {
		return monthlyFee;
	}


	public void setMonthlyFee(int monthlyFee) {
		this.monthlyFee = monthlyFee;
	}


	public int getCurrentOccupancy() {
		return currentOccupancy;
	}


	public void setCurrentOccupancy(int currentOccupancy) {
		this.currentOccupancy = currentOccupancy;
	}

	   
    public String getRoomfloor() {
		return roomfloor;
	}


	public void setRoomfloor(String roomfloor) {
		this.roomfloor = roomfloor;
	}


	public Date getCheckOutDate() {
		return checkOutDate;
	}


	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getApplicationUserId() {
        return applicationUserId;
    }

    public void setApplicationUserId(int applicationUserId) {
        this.applicationUserId = applicationUserId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Date getcheckOutDate() {
        return checkOutDate;
    }

    public void setcheckOutDate(Date checkOutDate) {
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Timestamp getApplicationCreatedAt() {
        return applicationCreatedAt;
    }

    public void setApplicationCreatedAt(Timestamp applicationCreatedAt) {
        this.applicationCreatedAt = applicationCreatedAt;
    }
    


}
