package com.dheemanth.hope.complaints;

import java.time.LocalDate;

public class Complaint {
	
	private int complaintNumber;
	private String complainantName;
	private String phoneNumber;
	private String description;
	private String complaintLocation;
	private String issue;
	private LocalDate date;
	private String imageUrl;
	
	public int getComplaintNumber() {
		return complaintNumber;
	}
	public void setComplaintNumber(int complaintNumber) {
		this.complaintNumber = complaintNumber;
	}
	public String getComplainantName() {
		return complainantName;
	}
	public void setComplainantName(String complainantName) {
		this.complainantName = complainantName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getComplaintLocation() {
		return complaintLocation;
	}
	public void setComplaintLocation(String complaintLocation) {
		this.complaintLocation = complaintLocation;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	

}
