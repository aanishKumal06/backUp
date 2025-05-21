package com.marshmallowhaven.Model;

import java.util.Date;

public class BookingStat {
    private String roomType;
    private Date bookingDate;   
    private int totalBookings;

    public BookingStat(String roomType, Date bookingDate, int totalBookings) {
        this.roomType = roomType;
        this.bookingDate = bookingDate;
        this.totalBookings = totalBookings;
    }
    
  

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getTotalBookings() {
        return totalBookings;
    }

    public void setTotalBookings(int totalBookings) {
        this.totalBookings = totalBookings;
    }


}
