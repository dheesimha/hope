package com.dheemanth.hope.complaints;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="complaints")
public class Complaint {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long complaintNumber;
	private String complainantName;
	private String phoneNumber;
	private String description;
	private String complaintLocation;
	private String issue;
	private LocalDate date;
	private String imageUrl;
	
	public Complaint() {
		
	}
	
	public Complaint(long complaintNumber, String complainantName, String phoneNumber, String description,
			String complaintLocation, String issue, LocalDate date, String imageUrl) {
		super();
		this.complaintNumber = complaintNumber;
		this.complainantName = complainantName;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.complaintLocation = complaintLocation;
		this.issue = issue;
		this.date = date;
		this.imageUrl = imageUrl;
	}
	
	
	public long getComplaintNumber() {
		return complaintNumber;
	}
	public void setComplaintNumber(long complaintNumber) {
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

	@Override
	public String toString() {
		return "Complaint [complaintNumber=" + complaintNumber + ", complainantName=" + complainantName
				+ ", phoneNumber=" + phoneNumber + ", description=" + description + ", complaintLocation="
				+ complaintLocation + ", issue=" + issue + ", date=" + date + ", imageUrl=" + imageUrl + "]";
	}
	

}
