package com.dheemanth.hope.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dheemanth.hope.complaints.Complaint;
import com.dheemanth.hope.repository.ComplaintsRepository;

@RestController
public class Controller {
	
	private ComplaintsRepository complaintsRepository;
	
	public Controller(ComplaintsRepository complaintsRepository) {
		this.complaintsRepository = complaintsRepository;
	}
	
	@GetMapping("/complaints")
	public String getComplaint(@RequestParam long id) {
		Complaint complaint = complaintsRepository.getById(id);
		return complaint.toString();
	}
	
	
	
	
	

}
