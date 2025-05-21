package com.marshmallowhaven.Model;

import java.sql.Timestamp;

public class UserComplaint {
	
	   private String fullName;
	    private int complaintId;
	    private String complaintType;
	    private String description;
	    private Timestamp createdAt;




	    public UserComplaint(String fullName, int complaintId, String complaintType, String description, Timestamp createdAt) {
	        this.fullName = fullName;
	        this.complaintId = complaintId;
	        this.complaintType = complaintType;
	        this.description = description;
	        this.createdAt = createdAt;
	    }

	    // Getters and Setters
	    public String getFullName() {
	        return fullName;
	    }

	    public void setFullName(String fullName) {
	        this.fullName = fullName;
	    }

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



}
