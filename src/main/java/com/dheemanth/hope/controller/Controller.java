package com.dheemanth.hope.controller;

import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dheemanth.hope.complaints.Complaint;
import com.dheemanth.hope.service.ComplaintsService;

@RestController
public class Controller {
	
	private ComplaintsService complaintsService;
	private static final Logger logger = LoggerFactory.getLogger(Controller.class);
	
	public Controller(ComplaintsService complaintsService) {
		this.complaintsService = complaintsService;
	}
	
	@GetMapping("/complaints")
	public ResponseEntity<Complaint> getComplaint(@RequestParam long id) {
		
		try {
			Optional<Complaint> complaint = complaintsService.getComplaint(id);
			
			if(complaint.isPresent()) {
				return ResponseEntity.ok(complaint.get());
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		
		catch(Exception e) {
			logger.error("An error occured at "+e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		
	}
	
	
	@PostMapping("/complaints")
	public ResponseEntity<?> submitComplaint(@RequestBody Complaint complaint){
		
		try {
			Complaint savedComplaint = complaintsService.createComplaint(complaint);
		
			return ResponseEntity.status(HttpStatus.CREATED).body(savedComplaint);	
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occured: "+e.getMessage());
		}
		
	}
	
	@PatchMapping("/complaints")
	public ResponseEntity<Complaint> updateComplaint(@RequestParam long id, @RequestBody Map<String,Object> updates){
		try {
			Optional<Complaint> updatedComplaint = complaintsService.updateComplaint(id,updates);
			
			if(updatedComplaint.isPresent()) {
				return ResponseEntity.ok(updatedComplaint.get());
			}
			
			return ResponseEntity.notFound().build();
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	
	
	
	
	
	

}
