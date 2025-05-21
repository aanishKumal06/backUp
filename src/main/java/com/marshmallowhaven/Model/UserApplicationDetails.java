package com.marshmallowhaven.Model;

import java.sql.Date;


public class UserApplicationDetails {
    private int applicationUserId;
    private String roomNumber;
    private String roomType;
    private String roomfloor;
    private int monthlyFee;
    private String durationOfStay;
    private Date expectedCheckIn;
    private String status;

	public UserApplicationDetails(int applicationUserId,   String roomNumber,
            String roomType,   String roomfloor, int monthlyFee, String durationOfStay, Date expectedCheckIn,
                String status) {
		this.applicationUserId = applicationUserId;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.roomfloor = roomfloor;
		this.monthlyFee = monthlyFee;
		this.durationOfStay = durationOfStay;
		this.expectedCheckIn = expectedCheckIn;
		this.status = status;

		}
    
    public int getApplicationUserId() {
		return applicationUserId;
	}


	public void setApplicationUserId(int applicationUserId) {
		this.applicationUserId = applicationUserId;
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


	public String getRoomfloor() {
		return roomfloor;
	}


	public void setRoomfloor(String roomfloor) {
		this.roomfloor = roomfloor;
	}


	public int getMonthlyFee() {
		return monthlyFee;
	}


	public void setMonthlyFee(int monthlyFee) {
		this.monthlyFee = monthlyFee;
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}




}
