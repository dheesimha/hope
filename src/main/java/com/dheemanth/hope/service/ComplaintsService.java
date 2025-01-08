package com.dheemanth.hope.service;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.dheemanth.hope.complaints.Complaint;
import com.dheemanth.hope.repository.ComplaintsRepository;

@Service
public class ComplaintsService {
	
	private ComplaintsRepository complaintsRepository;
	
	public ComplaintsService(ComplaintsRepository complaintsRepository) {
		this.complaintsRepository = complaintsRepository;
	}
	
	public Complaint createComplaint(Complaint complaint) {
		return complaintsRepository.save(complaint);
	}
	
	
	public Optional<Complaint> getComplaint(long id){
		return complaintsRepository.findById(id);
	}
	
	public Optional<Complaint> updateComplaint(long id, Map<String,Object> updates){
		
		Optional<Complaint> optionalComplaint = complaintsRepository.findById(id);
		
		if(optionalComplaint.isPresent()) {
			
			Complaint complaint = optionalComplaint.get();
			
			updates.forEach((key,value)->{
				
				Field field = ReflectionUtils.findField(Complaint.class, key);
				
				if(field!=null && value!=null) { 
					field.setAccessible(true);
					
					Object convertedValue = convertValueToFieldType(value, field.getType());
					ReflectionUtils.setField(field, complaint, value);
					
					
				}
			});
			
			complaintsRepository.save(complaint);
			
			return Optional.of(complaint);
		}
		
		return Optional.empty();
	}




private Object convertValueToFieldType(Object value, Class<?> fieldType) {
	
	if(fieldType.isAssignableFrom(value.getClass())) {
		return value;
	}
	
	if(fieldType.equals(Integer.class) || fieldType.equals(int.class)) {
		return Integer.parseInt(value.toString());
	}
	if(fieldType.equals(Long.class) || fieldType.equals(long.class)) {
		return Long.parseLong(value.toString());
	}
	if(fieldType.equals(Double.class)|| fieldType.equals(double.class)) {
		return Double.parseDouble(value.toString());
	}
	if(fieldType.equals(Boolean.class) || fieldType.equals(boolean.class)) {
		return Boolean.parseBoolean(value.toString());
	}
	
	return value.toString();
}

}